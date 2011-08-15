package pattern.part3.chapter8.remote;

/**
 * Date: Dec 7, 2010
 * Time: 8:39:11 PM
 *|| */
public class Client {
    public static void main(String[] args) {
        Service service = new Service_Stub();
        String result = service.hello();
        System.out.println(result);
    }
}