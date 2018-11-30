package lesson1;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Calendar;
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JDBC2GetAll {
    static final String login = "root";
    static final String password = "root";
    static final String dbUrl = "jdbc:mysql://localhost:3306";
    static final String insertNew = "insert into dish(title, description, rating,"+
            "published, created, icon)" +
            "Values" +
            "(?, ?, ?, ?, ?, ?)";
    static final String getAll = "Select * from dish";
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement stat = null;


        try{
            conn = DriverManager.getConnection(dbUrl, login, password);
            Statement stat2 = conn.createStatement();
            stat2.execute("use TestDb");
            stat = conn.prepareStatement(getAll);
            ResultSet resultSet = stat.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getNString("title");
                String description = resultSet.getNString("description");
                Double rating = resultSet.getDouble("rating");
                boolean published = resultSet.getBoolean("published");
                Date date = resultSet.getDate("created");
                Blob icon = resultSet.getBlob("icon");
                //byte[] bytes = resultSet.getBytes("icon");
                System.out.println(id + " " + " " + title + " " + description + " "
                + rating + " " + published + " " + date);
                //System.out.println(Arrays.toString(bytes));
            }
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
    }
}
