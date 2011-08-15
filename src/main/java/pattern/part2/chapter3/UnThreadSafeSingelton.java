package pattern.part2.chapter3;

/**
 * Date: 2009-10-31
 * Time: 15:20:17
 */
public class UnThreadSafeSingelton {
    private static UnThreadSafeSingelton instatnce;

    private UnThreadSafeSingelton() {
    }

    public static UnThreadSafeSingelton getInstance() {
        if (instatnce == null) {
            instatnce = new UnThreadSafeSingelton();
        }
        return instatnce;
    }
}
