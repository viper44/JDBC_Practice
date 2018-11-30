package lesson2.daoCars.dao;

import lesson2.daoCars.entity.Car;

import java.util.List;

public interface CarDao {
    void add(Car car);

    List<Car> getAll();

    Car getById(int id);

    void updatePrice(int price, int carId);

    void remove(int id);

    void removeByMark(String mark);
}
