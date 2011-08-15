package pattern.part2.chapter6.factory;

/**
 * Date: Nov 19, 2010
 * Time: 4:33:54 PM
 *|| */
public class Service1Factory {
    public static Service1 getService1Instance() {
        Service2 service2 = Service2Factory.getService2Instance();
        return new Service1Impl(service2);
    }
}
