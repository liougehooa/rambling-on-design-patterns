package pattern.part3.chapter7;

import pattern.part3.chapter7.domain.GenericRepository;
import pattern.part3.chapter7.domain.User;
import pattern.part3.chapter7.domain.UserLog;

import java.util.List;

import static pattern.Asserts.assertEquals;
import static pattern.part3.chapter7.HibernateUtils.closeCurrentSession;
import static pattern.part3.chapter7.JpaUtils.closeCurrentEntityManager;

/**
 * Date: 2009-12-2
 * Time: 7:44:24
 */
public class DecoratorTestDrive {
    private DecoratorTest decoratorTest;

    private GenericRepository genericrepository;

    public void setGenericrepository(GenericRepository genericrepository) {
        this.genericrepository = genericrepository;
    }

    public DecoratorTestDrive(DecoratorTest decoratorTest) {
        this.decoratorTest = decoratorTest;
    }


    public void testSave() {
        try {
            decoratorTest.setup(this);

            //create a new user
            User user = new User();
            user.setName("Jason");
            genericrepository.save(user);
            decoratorTest.commitAndRenewTx();

            //to verify
            User userFromDb = (User) genericrepository.get(User.class, user.getId());
            assertEquals(user.getId(), userFromDb.getId());

            List list = genericrepository.query("SELECT userlog FROM UserLog userlog where id = " + userFromDb.getId());

            assertEquals(list.size(), 1);

            UserLog userLog = (UserLog) list.get(0);
            assertEquals(userLog.getId(), userFromDb.getId());
            assertEquals(userLog.getName(), userFromDb.getName());
        } finally {
            decoratorTest.tearDown();
        }

    }

    public void testUpdate() {
        try {
            decoratorTest.setup(this);

            //create a new user
            User user = new User();
            user.setName("Jason");
            genericrepository.save(user);
            decoratorTest.commitAndRenewTx();

            User userFromDb = (User) genericrepository.get(User.class, user.getId());
            userFromDb.setName("Jason Evans");
            genericrepository.update(userFromDb);
            decoratorTest.commitAndRenewTx();

            //to verify
            List list = genericrepository.query("SELECT userlog FROM UserLog userlog where id = " + userFromDb.getId());

            assertEquals(list.size(), 2);
            UserLog userLog = (UserLog) list.get(list.size() - 1);
            assertEquals(userLog.getId(), userFromDb.getId());
            assertEquals("Jason Evans", userFromDb.getName());
            assertEquals(userLog.getName(), userFromDb.getName());
        } finally {
            decoratorTest.tearDown();
        }
    }

    static enum DecoratorTest {
        JPATEST {
            void setup(DecoratorTestDrive decoratorTestDrive) {
                decoratorTestDrive.setGenericrepository(new LogRepository<User>(new GenericRepositoryJpa<User>()));
                JpaUtils.beginTransaction();
            }

            void commitAndRenewTx() {
                JpaUtils.commit();
                JpaUtils.beginTransaction();
            }

            void tearDown() {
                JpaUtils.commit();
                closeCurrentEntityManager();
            }
        },
        HBTEST {
            void setup(DecoratorTestDrive decoratorTestDrive) {
                decoratorTestDrive.setGenericrepository(new LogRepository<User>(new GenericRepositoryHibernate<User>()));
                HibernateUtils.beginTransaction();
            }

            void commitAndRenewTx() {
                HibernateUtils.commit();
                HibernateUtils.beginTransaction();
            }

            void tearDown() {
                HibernateUtils.commit();
                closeCurrentSession();
            }
        };

        abstract void setup(DecoratorTestDrive decoratorTestDrive);

        abstract void commitAndRenewTx();

        abstract void tearDown();
    }

    public static void main(String[] args) {
        DecoratorTestDrive decoratorTestDrive = new DecoratorTestDrive(DecoratorTest.HBTEST);

        System.out.println("Start to test Hibernate...");
        decoratorTestDrive.testSave();
        decoratorTestDrive.testUpdate();
        System.out.println("End testing Hibernate");

        decoratorTestDrive = new DecoratorTestDrive(DecoratorTest.JPATEST);

        System.out.println("Start to test Jpa...");
        decoratorTestDrive.testSave();
        decoratorTestDrive.testUpdate();
        System.out.println("End testing Jpa");
    }
}
