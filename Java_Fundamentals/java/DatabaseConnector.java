import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/oms_database";
        String user = "postgres";
        String password = "Passw0rd@123";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established successfully.");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
