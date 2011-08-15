package pattern.part2.chapter6.constructor;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

/**
 * Date: 2009-11-14
 * Time: 15:49:50
 */
public class Client {
    private Service1 service1;

    public Client(Service1 service1) {
        this.service1 = service1;
    }

    public void doSomething() {
        service1.execute();
    }

    private static MutablePicoContainer configure() {
        MutablePicoContainer pico = new DefaultPicoContainer();
        pico.addComponent(Service1Impl.class);//register an implementation of Service1
        pico.addComponent(Service2Impl.class);
        pico.addComponent(Client.class);
        return pico;
    }

    public static void main(String[] args) {
        MutablePicoContainer pico = configure();
        Client client = pico.getComponent(Client.class);
        client.doSomething();
    }
}