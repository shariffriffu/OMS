import os
import time
import requests
import asyncio
from openai import OpenAI
from telegram import Bot, InlineKeyboardButton, InlineKeyboardMarkup, Update
from telegram.ext import ApplicationBuilder, CallbackQueryHandler, ContextTypes
from playwright.async_api import async_playwright

# Initialize clients
openai_client = OpenAI()
TELEGRAM_TOKEN = os.getenv("TELEGRAM_BOT_TOKEN")
TELEGRAM_CHAT_ID = os.getenv("TELEGRAM_CHAT_ID")
bot = Bot(token=TELEGRAM_TOKEN) if TELEGRAM_TOKEN else None

PROFILE = {
    "first_name": "Rifakhath Ulla",
    "last_name": "Shariff",
    "email": "sharifshahid7890@gmail.com",
    "phone": "+917406912898",
    "resume_path": os.path.abspath("Rifakhath_Ulla_Shariff_Updated_Resume.pdf"),
    "base_summary": "Senior Software Engineer with 4+ years in Flutter, React Native, WSO2, Node.js, and Oracle telecom architectures."
}

class HybridJobAgent:
    def __init__(self):
        self.applied_log = "applied_jobs.txt"

    def log(self, text: str):
        entry = f"{time.strftime('%Y-%m-%d %H:%M:%S')} - {text}"
        with open(self.applied_log, "a") as f:
            f.write(entry + "\n")
        print(f"[AGENT] {text}")

    def fetch_jobs(self):
        """Fetch remote jobs from clean JSON feed"""
        url = "https://remoteok.com/api?tag=flutter"
        res = requests.get(url, headers={"User-Agent": "Mozilla/5.0"})
        if res.status_code == 200:
            data = res.json()
            return data[1:] if len(data) > 1 else []
        return []

    def tailor_pitch_with_llm(self, job_title: str, company: str, description: str) -> str:
        """Uses LLM to write a 2-line targeted cover note / match analysis"""
        prompt = f"""
        Role: {job_title} at {company}
        Candidate Profile: {PROFILE['base_summary']} + WSO2 API Gateway config experience.
        Job Desc Excerpt: {description[:600]}
        
        Write a sharp 2-bullet pitch highlighting why Shariff fits this exact role. Keep it concise for Telegram.
        """
        response = openai_client.chat.completions.create(
            model="gpt-4o-mini",
            messages=[{"role": "user", "prompt" if False else "content": prompt}],
            max_tokens=150
        )
        return response.choices[0].message.content.strip()

    async def send_approval_request(self, job: dict, pitch: str):
        if not bot or not TELEGRAM_CHAT_ID:
            self.log("Telegram token/chat_id missing. Skipping notification.")
            return

        title = job.get("position")
        company = job.get("company")
        apply_url = job.get("url")
        salary = job.get("salary", "Not specified")

        msg = (
            f"🔥 **High Match Found!**\n"
            f"**Role:** {title} @ {company}\n"
            f"**Salary:** {salary}\n\n"
            f"💡 **AI Match Pitch:**\n{pitch}\n\n"
            f"🔗 {apply_url}"
        )
        
        # Unique callback payload encoded with URL (keep short or hash/store globally in production)
        keyboard = [
            [
                InlineKeyboardButton("✅ Autofill & Review", callback_data=f"apply|{company}|{apply_url}"),
                InlineKeyboardButton("❌ Skip", callback_data="skip")
            ]
        ]
        reply_markup = InlineKeyboardMarkup(keyboard)
        await bot.send_message(chat_id=TELEGRAM_CHAT_ID, text=msg, parse_mode="Markdown", reply_markup=reply_markup)

    async def run_browser_autofill(self, apply_url: str):
        """Launches Playwright non-headless for user review & final submit"""
        self.log(f"Launching browser for: {apply_url}")
        async with async_playwright() as p:
            browser = p.chromium.launch(headless=False)
            page = await browser.new_page()
            try:
                await page.goto(apply_url)
                if "greenhouse.io" in apply_url:
                    await page.wait_for_selector("#first_name", timeout=6000)
                    await page.fill("#first_name", PROFILE["first_name"])
                    await page.fill("#last_name", PROFILE["last_name"])
                    await page.fill("#email", PROFILE["email"])
                    await page.fill("#phone", PROFILE["phone"])
                    file_input = page.locator("input[data-qa='resume-input'], input[type='file']").first
                    if await file_input.count() > 0:
                        await file_input.set_input_files(PROFILE["resume_path"])
                    self.log("Autofilled Greenhouse form.")
                else:
                    self.log("Navigated to external ATS form.")
                
                # Keep browser open for user to handle custom questions / submit
                print("👀 Browser open. Complete custom Qs and submit manually, press Ctrl+C or wait 120s...")
                await asyncio.sleep(120)
            except Exception as e:
                self.log(f.format(f"Browser automation error: {e}"))
            finally:
                await browser.close()

    def run_scout_loop(self):
        self.log("Scouting jobs...")
        jobs = self.fetch_jobs()
        for job in jobs[:3]: # batch sample
            title = job.get("position", "")
            company = job.get("company", "")
            desc = job.get("description", "")
            
            if "senior" in title.lower() or "lead" in title.lower() or "flutter" in title.lower():
                self.log(f"Evaluating match for {title} @ {company}")
                pitch = self.tailor_pitch_with_llm(title, company, desc)
                asyncio.run(self.send_approval_request(job, pitch))
                time.sleep(2)

# Telegram Callback Handler setup for interaction
async def button_callback(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    await query.answer()
    data = query.data
    
    if data.startswith("apply|"):
        _, company, apply_url = data.split("|", 2)
        await query.edit_message_text(text=f"🚀 Launching browser autofill for **{company}**...")
        agent = HybridJobAgent()
        await agent.run_browser_autofill(apply_url)
    elif data == "skip":
        await query.edit_message_text(text="⏭️ Skipped job application.")

if __name__ == "__main__":
    # Run scout cycle once or hook into a scheduler/cron
    agent = HybridJobAgent()
    agent.run_scout_loop()
    
    # Optional: Uncomment below to run Telegram bot listener for inline button clicks
    # app = ApplicationBuilder().token(TELEGRAM_TOKEN).build()
    # app.add_handler(CallbackQueryHandler(button_callback))
    # app.run_polling()