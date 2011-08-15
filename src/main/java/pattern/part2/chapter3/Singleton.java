package pattern.part2.chapter3;

/**
 * Date: 2009-10-31
 * Time: 14:16:25
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    //other useful fields...

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    //other useful methods...
}

