package pattern.part2.chapter3;

/**
 * User: liujih
 * Date: Mar 20, 2011
 * Time: 9:54:34 PM
 */
public class Client {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        UnThreadSafeSingelton unThreadSafeSingelton = UnThreadSafeSingelton.getInstance();
        ThreadSafeSingelton threadSafeSingelton = ThreadSafeSingelton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton = DoubleCheckSingleton.getInstance();
        LazyLoadedSingleton lazyLoadedSingleton = LazyLoadedSingleton.getInstance();
        SerialibleSingleton serialibleSingleton = SerialibleSingleton.getInstance();
    }
}
