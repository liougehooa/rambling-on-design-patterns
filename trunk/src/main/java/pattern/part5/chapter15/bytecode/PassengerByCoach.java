package pattern.part5.chapter15.bytecode;

import java.util.concurrent.TimeUnit;

/**
 * Date: 2009-11-18
 * Time: 0:22:16
 */
public class PassengerByCoach extends HappyPeople {
    @Override
    protected void travel() {
        //Travel by Coach...
        System.out.println("Travelling by Coach...");
        try {//try to sleep for a while...
            TimeUnit.MILLISECONDS.sleep(600l);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}
