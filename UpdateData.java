import java.sql.*;

public class UpdateData {
    private static final String URL="jdbc:postgresql://localhost:5432/student_db";
    private static final String USER="postgres";
    private static final String PASSWORD="1234";

    public static void main(String[] args) {
        int update_studentId=2;
        String update_studentName="Aswathi T";
        String gradeUpadted="A";
        try(Connection conn= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement stmt=conn.prepareStatement("select * from students");
            ResultSet rs=stmt.executeQuery();
        )
        {
            System.out.println("Data before Updation");
            while (rs.next()){
                int id=rs.getInt("student_id");
                String name=rs.getString("student_name");
                String grade=rs.getString("grade");
                System.out.println(id+" "+name+" "+grade);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        try(Connection conn= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement stmt=conn.prepareStatement("update students set grade=? where student_id=?");
          //  ResultSet rs=stmt.executeQuery();
        )
        {
            System.out.println("Data After Updation");
            stmt.setInt(2,update_studentId);
            stmt.setString(1,gradeUpadted);
            int rowsUpdated=stmt.executeUpdate();
            if(rowsUpdated>0){
                System.out.println("Updated");
            }else {
                System.out.println("Updation failed");
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
