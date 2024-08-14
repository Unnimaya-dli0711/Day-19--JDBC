import java.sql.*;

public class SelectQuery {
    private static final String URL="jdbc:postgresql://localhost:5432/Insurance_DB";
    private static final String USER="postgres";
    private static final String PASSWORD="1234";

    public static void main(String[] args) throws SQLException {
        try(Connection conn= DriverManager.getConnection(URL,USER,PASSWORD);
             PreparedStatement stmt=conn.prepareStatement("select *  from customers");
             ResultSet rs=stmt.executeQuery();){

            while(rs.next()){
                int id=rs.getInt("customer_id");
                String name=rs.getString("first_name");
                String last_name=rs.getString("last_name");
                System.out.println(id+" "+name+" "+last_name+"\n");
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
