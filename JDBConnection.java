import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
    private static final String URL="jdbc:postgresql://localhost:5432/Insurance_DB";
    private static final String USER="postgres";
    private static final String PASSWORD="1234";
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        if(conn!=null)
        {
            System.out.println("Connection established");
        }else {
            System.out.println("connection failed");
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
         JDBConnection.getConnection();
    }
}
