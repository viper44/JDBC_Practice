package lesson6.ex003;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@SuppressWarnings("unchecked")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorHelper {
    SessionFactory sessionFactory;

    public AuthorHelper(){
        sessionFactory = HibernateUtil.getFactory();
    }

    public List<Author> getAuthorList(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);
        Selection[] selections = {root.get("id"), root.get("name")};

        cq.select(cb.construct(Author.class, selections))
                .where(cb.like(root.get("last_name"), "%ab%")); // SELECT id, name FROM author where
                                                                    //last_name like %ogo%

        Query query = session.createQuery(cq);
        List<Author> authors = query.getResultList();
        session.close();
        return authors;
    }


    public Author getAuthoById(int id){
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);
        return author;
    }

    public void addAuthor(Author author) {
        Session session = sessionFactory.openSession();
        List<Author> authors = getAuthorList();
        for (Author author1 : authors) {
            if (author.getName().equals(author1.getName())) {
                System.out.println("This author already exist");
                return;
            }

        }
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }

    public void updateAuthor(String name, String secondName, int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author authorTMP = session.get(Author.class, id);
        authorTMP.setName(name);
        authorTMP.setLast_name(secondName);
        session.save(authorTMP);
        session.getTransaction().commit();
        session.close();
    }
    public void deleteById(int id){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Author author = session.get(Author.class, id);
        session.delete(author);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCriteria(){
        Session session = getSessionFactory().openSession();

        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Author> cd = cb.createCriteriaDelete(Author.class);
        Root<Author> root = cd.from(Author.class);
        cd.where(cb.greaterThan(root.get("id"), 1));
        Query query = session.createQuery(cd);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}
