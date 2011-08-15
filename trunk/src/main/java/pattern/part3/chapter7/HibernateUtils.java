package pattern.part3.chapter7;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;
import pattern.part3.chapter7.domain.User;
import pattern.part3.chapter7.domain.UserLog;

/**
 * Date: 2009-12-2
 * Time: 22:32:17
 */
public abstract class HibernateUtils {
    public static final ThreadLocal<Session> sessions = new ThreadLocal<Session>();

    public static Session getCurrentSession() throws HibernateException {
        Session s = sessions.get();
        if (s == null) {
            s = LazySessionFactoryHolder.sessionFactory.openSession();
            sessions.set(s);
        }
        return s;
    }


    public static void closeCurrentSession() throws HibernateException {
        Session s = sessions.get();
        sessions.set(null);
        if (s != null && s.isOpen()) s.close();
    }

    public static void beginTransaction() {
        getCurrentSession().getTransaction().begin();
    }

    public static void commit() {
        getCurrentSession().getTransaction().commit();
    }

    public static void rollback() {
        getCurrentSession().getTransaction().rollback();
    }

    private static class LazySessionFactoryHolder {  //holds sessionFactory
        private static final SessionFactory sessionFactory;

        static {
            sessionFactory = buildSessionFactory();
        }

        private static SessionFactory buildSessionFactory() {
            return new AnnotationConfiguration()
                    .addAnnotatedClass(UserLog.class)
                    .addAnnotatedClass(User.class)
                    .setProperty(Environment.HBM2DDL_AUTO, "create-drop")
                    .setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver")
                    .setProperty(Environment.URL, "jdbc:hsqldb:mem:user")
                    .setProperty(Environment.USER, "sa")
                    .setProperty(Environment.PASS, "")
                    .setProperty(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect")
                    .setProperty(Environment.SHOW_SQL, "false")
                    .buildSessionFactory();
        }
    }
}
