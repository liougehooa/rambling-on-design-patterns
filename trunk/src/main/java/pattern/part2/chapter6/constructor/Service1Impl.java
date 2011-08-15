package pattern.part2.chapter6.constructor;

/**
 * Date: Nov 19, 2010
 * Time: 4:37:42 PM
 *|| */
public class Service1Impl implements Service1 {
    private Service2 service2;

    public Service1Impl(Service2 service2) {
        this.service2 = service2;
    }

    public void execute() {
        System.out.println("Service1 is doing something.");
        service2.execute();
    }
}