package pattern.part3.chapter7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Date: Dec 2, 2010
 * Time: 7:06:23 PM
 *|| */
public abstract class JpaUtils {
    public static final ThreadLocal<EntityManager> entityManagers = new ThreadLocal<EntityManager>();

    public static EntityManager getCurrentEntityManager() {
        EntityManager manager = entityManagers.get();
        if (manager == null) {

            manager = LazyManagerFactoryHolder.entityManagerFactory.createEntityManager();
            entityManagers.set(manager);
        }
        return manager;
    }


    public static void closeCurrentEntityManager() {
        EntityManager em = entityManagers.get();
        entityManagers.set(null);
        if (em != null && em.isOpen()) em.close();
    }

    private static class LazyManagerFactoryHolder {  //holds managerFactory
        private static final EntityManagerFactory entityManagerFactory;

        static {
            entityManagerFactory = buildEntityManagerFactory();
        }

        private static EntityManagerFactory buildEntityManagerFactory() {
            return Persistence.createEntityManagerFactory("jpaUnit");
        }
    }

    public static void beginTransaction() {
        getCurrentEntityManager().getTransaction().begin();
    }

    public static void commit() {
        getCurrentEntityManager().getTransaction().commit();
    }

    public static void rollback() {
        getCurrentEntityManager().getTransaction().rollback();
    }
}
