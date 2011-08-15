package pattern.part2.chapter6.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Date: 2009-11-14
 * Time: 15:49:50
 */
public class Client {
    private Service1 service1;

    public void setService1(Service1 service1) {
        this.service1 = service1;
    }

    public void doSomething() {
        service1.execute();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("pattern/part2/chapter6/setter/spring-beans.xml");
        Client client = (Client) ctx.getBean("client");

        client.doSomething();
    }
}