import java.sql.*;

public class InsertData {
    private static final String URL="jdbc:postgresql://localhost:5432/inventory_db";
    private static final String USER="postgres";
    private static final String PASSWORD="1234";

    public static void main(String[] args) {
        int productId=1;
        String productName="oil";
        double price=30.0;
        int quantity=4;
        try(Connection conn= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement stmt=conn.prepareStatement("insert into products values (? ,? ,? ,?)");
            ){
            stmt.setInt(1,productId);
            stmt.setString(2,productName);
            stmt.setDouble(3,price);
            stmt.setInt(4,quantity);
            int rowsInserted= stmt.executeUpdate();
            System.out.println(rowsInserted);
            if(rowsInserted>0){
                System.out.println("Product inserted");
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
