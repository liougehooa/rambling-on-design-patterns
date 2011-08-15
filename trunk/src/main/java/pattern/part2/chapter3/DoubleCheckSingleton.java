package pattern.part2.chapter3;

/**
 * Date: 2009-10-31
 * Time: 16:02:11
 */
public class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton instatnce = null;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (instatnce == null) { //  check if it is created.
            synchronized (DoubleCheckSingleton.class) {//synchronize creation block
                if (instatnce == null) //double check if it is created
                    instatnce = new DoubleCheckSingleton();
            }
        }
        return instatnce;
    }
}