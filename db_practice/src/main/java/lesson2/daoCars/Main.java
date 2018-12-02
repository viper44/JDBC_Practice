package lesson2.daoCars;

import lesson2.daoCars.dao.CarDao;
import lesson2.daoCars.dao.DAOFactory;
import lesson2.daoCars.dao.IDAOFactory;
import lesson2.daoCars.entity.Car;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        CarDao carDao = factory.getCarDao();
        Car car = new Car("AUDI", "R8", 200000);
       // carDao.add(car);
        List<Car> cars = carDao.getAll();
        for (Car c : cars){
            System.out.println(c);
        }

        //System.out.println(carDao.getById(10));
//        carDao.updatePrice(50, 11);
//        System.out.println(carDao.getById(11));
//        System.out.println(carDao.getById(1));
        carDao.remove(5);
//        carDao.removeByMark("AUDI");
//        List<Car> cars2 = carDao.getAll();
//        for (Car c2 : cars2){
//            System.out.println(c2);
//        }
    }
}
