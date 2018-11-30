package lesson2.daoCars.dao;

public interface IDAOFactory {
    CarDao getCarDao();
    ClientDao getClientDao();
}
