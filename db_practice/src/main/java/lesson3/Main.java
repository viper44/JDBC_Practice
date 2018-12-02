package lesson3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
//       Animal animal = new Animal("momo", 10, true);
//        Animal animal1 = new Animal("keke", 2, false);
//        animal1.setId(2);
//        animal.setId(3);
        ClientDetails details = new ClientDetails("misha", 20, "0660660660");
       // details.setId(2);
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(details);
        session.getTransaction().commit();
        session.close();
  }

}
