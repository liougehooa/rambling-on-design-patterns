package pattern.part2.chapter3;

/**
 * Date: 2009-10-31
 * Time: 15:55:48
 */
public class ThreadSafeSingelton {
    private static ThreadSafeSingelton instatnce;

    private ThreadSafeSingelton() {
    }

    public static synchronized ThreadSafeSingelton getInstance() {
        if (instatnce == null) {
            instatnce = new ThreadSafeSingelton();
        }
        return instatnce;
    }
}
