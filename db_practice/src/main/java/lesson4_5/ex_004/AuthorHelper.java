package lesson4_5.ex_004;

import lesson4_5.HibernateUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

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
        CriteriaQuery cq = cb.createQuery(lesson4_5.insert_and_update.Author.class);
        Root<Author> root = cq.from(Author.class);
        Selection[] selections = {root.get("id"), root.get("age")};
        cq.select(cb.construct(Author.class, selections));
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
                System.out.println("This author already exists");
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
        authorTMP.setLastName(secondName);
        session.save(authorTMP);
        session.getTransaction().commit();
        session.close();
    }
}
