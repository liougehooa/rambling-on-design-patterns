package pattern.part2.chapter6.factory;

/**
 * Date: Nov 19, 2010
 * Time: 4:33:54 PM
 *|| */
public class Service2Factory {
    public static Service2 getService2Instance() {
        return new Service2Impl();
    }
}