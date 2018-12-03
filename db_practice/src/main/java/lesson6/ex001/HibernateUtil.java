package lesson6.ex001;



import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;


    public static synchronized SessionFactory getFactory() {
        if (factory == null){
            try{
                factory = new Configuration()
                        .configure("lesson6_ex001.config.xml")
                        .buildSessionFactory();
            } catch (HibernateException e){
                e.printStackTrace();
            }
        }
        return factory;
    }
}
