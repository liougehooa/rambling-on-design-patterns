package pattern.part3.chapter8.dynamic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static pattern.Asserts.assertEquals;
import static pattern.part3.chapter8.dynamic.SynchronizedHandler.newProxy;

/**
 * Date: Dec 20, 2010
 * Time: 7:54:07 PM
 * ||
 */
public class TestDrive {
    private final int max;

    public TestDrive(int max) {
        this.max = max;
    }

    private void increase(final Increasable increasable) throws Throwable {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future f1 = pool.submit(new Runnable() {
            @Override
            public void run() {
                increasable.increase(13);
            }
        });

        Future f2 = pool.submit(new Runnable() {
            @Override
            public void run() {
                increasable.increase(19);
            }
        });

        try {
            f1.get();
            f2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw e.getCause();
        } finally {
            pool.shutdown();
        }
    }

    public void testIncrease() {
        boolean illegalState = false;
        while (!illegalState) {
            try {
                Increasable increasable = new IncreaseImpl();
                increase(increasable);
            } catch (Throwable e) {
                //assert expected exception message
                assertEquals("Count state is illegal!", e.getMessage());
                illegalState = true;
            }
        }
        assertEquals(illegalState, true);
    }

    public void testSynchronizedIncrease() {
        Increasable increasable = newProxy(new IncreaseImpl());
        for (int i = 0; i < max; i++) {
            try {
                increase(increasable);
            } catch (Throwable e) {
                //fail to test, throw a new exception
                throw new RuntimeException("Synchronized Test Failed", e);
            }
        }
    }

    public static void main(String[] args) {
        TestDrive test = new TestDrive(157);//run synchronizedIncrease max=157 times
        System.out.println("Test non-thread-safe increment...");
        test.testIncrease();
        System.out.println("Test non-thread-safe increment successful.");

        System.out.println("Test thread-safe increment...");
        test.testSynchronizedIncrease();
        System.out.println("Test thread-safe increment successful.");
    }
}
