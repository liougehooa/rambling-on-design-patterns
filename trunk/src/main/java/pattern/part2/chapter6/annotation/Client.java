package pattern.part2.chapter6.annotation;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Date: 2009-11-14
 * Time: 15:49:50
 */
public class Client {
    private Service1 service1;

    @Inject
    public Client(Service1 service1) {
        this.service1 = service1;
    }

    public void doSomething() {
        service1.execute();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Client client = injector.getInstance(Client.class);

        client.doSomething();
    }
}