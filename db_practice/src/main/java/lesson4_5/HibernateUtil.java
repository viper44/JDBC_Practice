package lesson4_5;



import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;


    public static synchronized SessionFactory getFactory() {
        if (factory == null){
            try{
                factory = new Configuration()
                        .configure()
                        .buildSessionFactory();
            } catch (HibernateException e){
                e.printStackTrace();
            }
        }
        return factory;
    }
}
