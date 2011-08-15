package pattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: liujih
 * Date: Mar 17, 2011
 * Time: 3:21:17 PM
 */
public class AllTests {
    public static void main(String[] args) {

        new AllTests().runAllTests(args);
    }

    private void runAllTests(String[] args) {
        System.out.println("-------------------------------------------------------");
        System.out.println(" T E S T S");
        System.out.println("-------------------------------------------------------");

        for (String arg : args) {
            run(arg);
        }
    }

    private void run(String className) {
        try {
            Method main = Thread.currentThread().
                                 getContextClassLoader().
                                 loadClass(className).
                                 getMethod("main", new Class[]{String[].class});

            if (!main.isAccessible()) main.setAccessible(true);

            System.out.printf("\nStart testing %s...\n", className);
            main.invoke(null, (Object) null);
            System.out.printf("Tested %s successfully\n\n", className);
        } catch (ClassNotFoundException e) {
            Thread.currentThread().getThreadGroup().uncaughtException(Thread.currentThread(), e);
        } catch (NoSuchMethodException e) {
            Thread.currentThread().getThreadGroup().uncaughtException(Thread.currentThread(), e);
        } catch (InvocationTargetException e) {
            Thread.currentThread().getThreadGroup().uncaughtException(Thread.currentThread(), e);
        } catch (IllegalAccessException e) {
            Thread.currentThread().getThreadGroup().uncaughtException(Thread.currentThread(), e);
        }
    }
}
