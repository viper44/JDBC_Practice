package lesson2.daoCars.dao;

import lesson2.daoCars.entity.Car;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class CarJDBCDao implements CarDao{
    @Override
    public void add(Car car){
        Connection connection = null;

        connection = getConnection();
        PreparedStatement statement = null;

        try {
            int markId = getMarkId(car.getMark(), connection);

            if (markId == -1){
                statement = connection.prepareStatement("insert into marks(mark) values (?) ");
                statement.setString(1, car.getMark());
                statement.execute();
                statement = connection.prepareStatement("select id from marks where mark = ?");
                statement.setString(1, car.getMark());
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                markId = resultSet.getInt(1);

            }
            statement = connection.prepareStatement("insert into cars(mark_id, model, price) " +
                    "VALUES (?, ?, ?) ");

            statement.setInt(1,markId);
            statement.setString(2,car.getModel());
            statement.setInt(3, car.getPrice());
            statement.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null && statement != null){
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private int getMarkId(String markName, Connection connection){
        try{
            PreparedStatement statement = connection.prepareStatement("select id from marks where mark = ?");

            statement.setString(1, markName);
            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Car> getAll(){
        List<Car> allCars = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT c.id, m.mark, c.model, c.price from cars as c" +
                    " inner join marks as m on m.id = c.mark_id");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                long id = rs.getLong(1);
                String mark = rs.getString(2);
                String model = rs.getString(3);
                int price = rs.getInt(4);
                Car car = new Car(mark, model,price);
                car.setId(id);
//                car.setMark(mark);
//                car.setModel(model);
//                car.setPrice(price);
                allCars.add(car);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null && statement != null){
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return allCars;
    }

    @Override
    public Car getById(int id2){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT c.id, m.mark, c.model, c.price from cars as c" +
                    " inner join marks as m on m.id = c.mark_id where c.id = ?");
            statement.setInt(1,id2);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String mark = resultSet.getString(2);
                String model = resultSet.getString(3);
                int price = resultSet.getInt(4);
                Car car = new Car(mark, model,price);
                car.setId(id);
                return car;
            }
        } catch (SQLException e ){

        } finally {
            if (connection != null && statement != null){
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }
    @Override
    public void updatePrice(int price, int carId){
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE cars set price = ? where id = ?");
            statement.setInt(1, price);
            statement.setInt(2, carId);
            int upd = statement.executeUpdate();
            System.out.println(upd);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null && statement != null){
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public void remove(int id){
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {

            statement = connection.prepareStatement("delete from cars where id = ?");
            statement.setInt(1, id);
            int upd = statement.executeUpdate();
            System.out.println(upd);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null && statement != null){
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    @Override
    public void removeByMark(String mark){
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            int mark_id = getMarkId(mark, connection);
            statement = connection.prepareStatement("delete from cars where mark_id = ?");

            statement.setInt(1, mark_id);
           int deleted = statement.executeUpdate();
            System.out.println("Deleted " + deleted + " cars");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (connection != null && statement != null){
                try{
                    statement.close();
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDb", "root", "root");
            return connection;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
