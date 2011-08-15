package pattern.part2.chapter6.factory;

/**
 * Date: Nov 19, 2010
 * Time: 4:33:13 PM
 *|| */
public class Client {
    public void doSomething() {
        Service1 service1 = Service1Factory.getService1Instance();
        service1.execute();
    }

    public static void main(String[] args) {
        new Client().doSomething();
    }
}