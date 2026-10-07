public class ManualTestRunner {
    public static void main(String[] args) {
        System.out.println("🚀 Running Shipping Strategy Tests...\n");

        FreeShipping strategy = new FreeShipping();
        int passed = 0;
        int failed = 0;

        // TEST 1: Order over $100 should be free
        double cost1 = strategy.calculate(150.0);
        if (cost1 == 0.0) {
            System.out.println("✅ PASS: Order $150 cost is $0.0");
            passed++;
        } else {
            System.out.println("❌ FAIL: Expected 0.0, but got " + cost1);
            failed++;
        }

        // TEST 2: Order under $100 should trigger $10 penalty
        double cost2 = strategy.calculate(50.0);
        // ??? YOUR CODE HERE ???
        // Write an if/else statement checking if cost2 == 10.0
        // If true, print "✅ PASS: Order $50 cost is $10.0" and passed++
        // If false, print "❌ FAIL: Expected 10.0, but got " + cost2 and failed++
        if(cost2==10.0){
            System.out.println("✅ PASS: Order $50 cost is $10.0");
            passed++;
        }else{
            System.out.println("❌ FAIL: Expected 10.0, but got " + cost2);
            failed++;
        }

        // TEST 3: Order exactly $100 should be free
        double cost3 = strategy.calculate(100.0);
        // ??? YOUR CODE HERE ???
        // Write an if/else statement checking if cost3 == 0git .0

        if(cost3 == 0.0){
            System.out.println("✅ PASS: Order $100 cost is $0.0");
            passed++;
        }else{
            System.out.println("❌ FAIL: Expected 0.0, but got " + cost3);
            failed++;
        }

        System.out.println("\n📊 Test Results: " + passed + " Passed, " + failed + " Failed");
        
        if (failed == 0) {
            System.out.println("🎉 ALL TESTS PASSED! Code is solid.");
        } else {
            System.out.println("⚠️ SOME TESTS FAILED. Check your logic.");
        }
    }
}

// Re-using your strategy from before
class FreeShipping {
    public double calculate(double orderTotal) {
        if (orderTotal >= 100) {
            return 0.0;
        } else {
            return 10.0;
        }
    }
}