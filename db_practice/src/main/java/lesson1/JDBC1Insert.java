package lesson1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;

public class JDBC1Insert {
    private static final String insertNew = "insert into dish(title, description, rating,"+
            "published, created, icon)" +
            "Values" +
            "(?, ?, ?, ?, ?, ?)";
    public static void main(String[] args) {
        String login = "root";
        String password = "root";
        String dbUrl = "jdbc:mysql://localhost:3306";



        try(Connection conn = DriverManager.getConnection(dbUrl, login, password)){
            Statement stat = conn.createStatement();
            stat.execute("use TestDb");
            stat.execute("create table if not exists dish(" +
                    "id MEDIUMINT not null AUTO_INCREMENT," +
                    "title VARCHAR (45)," +
                    "description VARCHAR (45)," +
                    "rating double (9,2)," +
                    "published TINYINT(4)," +
                    "created DATE," +
                    "icon LONGBLOB," +
                    "PRIMARY key (id))");
            PreparedStatement prestat = conn.prepareStatement(insertNew);
            prestat.setString(1, "Title");
            prestat.setString(2, "bla bla bla");
            prestat.setDouble(3, 4.9);
            prestat.setBoolean(4, false);
            prestat.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));
            prestat.setBlob(6, new FileInputStream("food.jpg"));
            prestat.execute();

            //stat.execute("drop DATABASE if exists TestDb");
//            stat.execute("create DATABASE TestDb");
//            stat.execute("use TestDb");
//            stat.execute("drop table if exists lesson1");
//            stat.execute("create table if not exists lesson1(" +
//                    "id MEDIUMINT not null AUTO_INCREMENT," +
//                    "name VARCHAR (30)," +
//                    "sername VARCHAR (30)," +
//                    "PRIMARY key (id))");

//
//            PreparedStatement prestat = conn.prepareStatement("insert into lesson1" +
//                    "(name, sername)" +
//                    "values " +
//                    "(?, ?)");

//            stat.executeUpdate("insert into lesson1" +
//                    "(name, sername)" +
//                    "values" +
//                    "('vasya', 'oblomov')," +
//                    "('petya', 'mitsurka')," +
//                    "('ivan', 'borsch')");
//            prestat.setString(1, "little");
//            prestat.setString(2, "big");
//            prestat.execute();
//            ResultSet resultSet = prestat.executeQuery("select * from lesson1");
//            while(resultSet.next()){
//                int id = resultSet.getInt(1);
//                int test = resultSet.getInt(1);
//                String name = resultSet.getNString(2);
//                String sername = resultSet.getNString(3);
//                System.out.println("Id = "+ test + id + " " + name + " " + sername );
//            }
        }catch (SQLException | IOException e){
//            System.out.println(e.getErrorCode());
        }
    }
}
