package pattern.part2.chapter6.servicelocator;

/**
 * Date: Nov 21, 2010
 * Time: 2:00:07 PM
 *|| */
public class Client {
    public void doSomething() {
        Service1 service1 = (Service1) ServiceLocator.lookup("service1");
        service1.execute();
    }

    public static void main(String[] args) {
        //Initialize the services
        ServiceLocator.configure();

        new Client().doSomething();
    }
}