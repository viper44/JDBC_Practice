package lesson6.ex001;

import lesson6.ex001.AuthorEntity;
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

    public List<AuthorEntity> getAuthorList(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(AuthorEntity.class);
        Root<AuthorEntity> root = cq.from(AuthorEntity.class);
        Selection[] selections = {root.get("id"), root.get("age")};
        cq.select(cb.construct(AuthorEntity.class, selections));
        Query query = session.createQuery(cq);
        List<AuthorEntity> authors = query.getResultList();
        session.close();
        return authors;
    }
    public AuthorEntity getAuthoById(int id){
        Session session = sessionFactory.openSession();
        AuthorEntity author = session.get(AuthorEntity.class, id);
        return author;
    }

    public void addAuthor(AuthorEntity author) {
        Session session = sessionFactory.openSession();
        List<AuthorEntity> authors = getAuthorList();
        for (AuthorEntity author1 : authors) {
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
        AuthorEntity authorTMP = session.get(AuthorEntity.class, id);
        authorTMP.setName(name);
        authorTMP.setLastName(secondName);
        session.save(authorTMP);
        session.getTransaction().commit();
        session.close();
    }
}
