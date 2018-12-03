package lesson4_5.ex_004;



import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;


    public static synchronized SessionFactory getFactory() {
        if (factory == null){
            try{
                factory = new Configuration()
                        .configure("ex004_config.xml")
                        .buildSessionFactory();
            } catch (HibernateException e){
                e.printStackTrace();
            }
        }
        return factory;
    }
}
