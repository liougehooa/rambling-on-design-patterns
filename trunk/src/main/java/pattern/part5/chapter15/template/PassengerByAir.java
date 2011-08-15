package pattern.part5.chapter15.template;

import java.util.concurrent.TimeUnit;

/**
 * Date: 2009-11-18
 * Time: 0:23:43
 */
public class PassengerByAir extends HappyPeople {
    @Override
    protected void onTravel() {
        //Travel by Air...
        System.out.println("Travelling by Air...");
        try {//try to sleep for a while...
            TimeUnit.MILLISECONDS.sleep(200l);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}