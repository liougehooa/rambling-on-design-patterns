package pattern.part2.chapter3;

/**
 * Date: 2009-11-1
 * Time: 23:32:43
 */
public class LazyLoadedSingleton {
    private LazyLoadedSingleton() {
    }

    private static class LazyHolder {  //holds the singleton class
        private static final LazyLoadedSingleton singletonInstatnce = new LazyLoadedSingleton();
    }

    public static LazyLoadedSingleton getInstance() {
        return LazyHolder.singletonInstatnce;
    }
}