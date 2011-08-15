package pattern.part2.chapter6.param;

/**
 * Date: Nov 19, 2010
 * Time: 4:33:13 PM
 *|| */
public class Client {
    public void doSomething(Service service) {
        service.execute();
    }

    public static void main(String[] args) {
        //create a service
        Service service = new ServiceImpl();

        //put new-created service instance by input parameter
        new Client().doSomething(service);
    }
}