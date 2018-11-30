package lesson1;

import java.sql.*;

public class JDBC3Delete {
    static final String login = "root";
    static final String password = "root";
    static final String dbUrl = "jdbc:mysql://localhost:3306";
    static final String Delete = "delete from dish where title = ?";
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement stat = null;


        try{
            conn = DriverManager.getConnection(dbUrl, login, password);
            Statement stat2 = conn.createStatement();
            stat2.execute("use TestDb");
            stat = conn.prepareStatement(Delete);
            stat.setString(1, "title");
            int res = stat.executeUpdate();
            System.out.println(res);

        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
    }
}
