package pattern.part2.chapter6.iface;

/**
 * Date: Nov 19, 2010
 * Time: 4:33:13 PM
 * ||
 */
public class Client implements ServiceAware {
    private Service service;

    @Override
    public void injectService(Service service) {
        this.service = service;
    }

    public void doSomething() {
        service.execute();
    }

    public static void main(String[] args) {
        InterfaceInjector.configure();
        Client client = InterfaceInjector.getInstance(Client.class);

        client.doSomething();
    }
}