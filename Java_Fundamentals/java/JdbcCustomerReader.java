import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class JdbcCustomerReader {
    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/oms_database";
        String user = "postgres";
        String password = "Passw0rd@123";

        String sql = "SELECT id, first_name, last_name, email FROM customers";
        try {
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Database connection established successfully.");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastname = rs.getString("last_name");
            String email = rs.getString("email");
            System.out.println("Customer ID: " + id + ", Name: " + firstName + " " + lastname + ", Email: " + email);

        }
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("Database connection closed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
