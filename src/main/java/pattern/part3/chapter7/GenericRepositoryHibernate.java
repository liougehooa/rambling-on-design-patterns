package pattern.part3.chapter7;

import pattern.part3.chapter7.domain.GenericRepository;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

import static pattern.part3.chapter7.HibernateUtils.getCurrentSession;

/**
 * Date: 2009-11-30
 * Time: 23:37:48
 */
public class GenericRepositoryHibernate<T> implements GenericRepository<T> {
    @Override
    public void save(T o) {
        if (o == null) {
            return;
        }
        Session session = getCurrentSession();//get hibernate session
        session.save(o);
    }

    @Override
    public void update(T o) {
        if (o == null) {
            return;
        }

        Session session = getCurrentSession();//get hibernate session
        session.update(o);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(Class<T> clazz, Serializable id) {
        if (id == null || clazz == null) {
            return null;
        }

        Session session = getCurrentSession();//get hibernate session
        return (T)session.get(clazz, id);
    }

    @Override
    public void delete(T o) {
        Session session = getCurrentSession();//get hibernate session
        session.delete(o);
    }

    @Override
    public List query(String qlString) {
        if (qlString == null || "".equals(qlString)) {
            return Collections.emptyList();
        }

        Session session = getCurrentSession();//get hibernate session
        Query query = session.createQuery(qlString);
        return query.list();
    }
    //other fields and methods...
}