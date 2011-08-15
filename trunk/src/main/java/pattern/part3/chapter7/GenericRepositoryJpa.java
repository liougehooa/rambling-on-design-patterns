package pattern.part3.chapter7;

import pattern.part3.chapter7.domain.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static pattern.part3.chapter7.JpaUtils.getCurrentEntityManager;

/**
 * Date: Dec 2, 2010
 * Time: 2:00:57 PM
 *|| */
public class GenericRepositoryJpa<T> implements GenericRepository<T> {
    @Override
    public void save(T o) {
        if (o == null) {
            return;
        }

        EntityManager entityManager = getCurrentEntityManager();
        entityManager.persist(o);
    }

    @Override
    public void update(T o) {
        //nothing
    }

    @Override
    public T get(Class<T> clazz, Serializable id) {
        if (id == null || clazz == null) {
            return null;
        }
        EntityManager entityManager = getCurrentEntityManager();
        return entityManager.find(clazz, id);
    }

    @Override
    public void delete(T o) {
        EntityManager entityManager = getCurrentEntityManager();//get hibernate session
        entityManager.remove(o);
    }

    @Override
    public List query(String qlString) {
        if (qlString == null || "".equals(qlString)) {
            return Collections.emptyList();
        }
        EntityManager entityManager = getCurrentEntityManager();
        Query query = entityManager.createQuery(qlString);
        return query.getResultList();
    }

    //other fields and methods...
}
