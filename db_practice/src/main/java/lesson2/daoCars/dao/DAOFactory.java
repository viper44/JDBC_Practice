package lesson2.daoCars.dao;

public class DAOFactory implements IDAOFactory {
    private static IDAOFactory factory;

    private DAOFactory(){

    }

    public static synchronized IDAOFactory getInstance(){
        if (factory == null){
            factory = new DAOFactory();
        }
        return factory;
    }
    @Override
    public CarDao getCarDao(){
        return new CarJDBCDao();
    }

    @Override
    public ClientDao getClientDao(){
        return null;
    }
}
