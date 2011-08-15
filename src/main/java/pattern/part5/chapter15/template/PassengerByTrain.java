package pattern.part5.chapter15.template;

import java.util.concurrent.TimeUnit;

/**
 * Date: 2009-11-18
 * Time: 0:20:05
 */
public class PassengerByTrain extends HappyPeople {
    @Override
    protected void onTravel() {
        //Travel by Train...
        System.out.println("Travelling by Train...");
        try {//try to sleep for a while...
            TimeUnit.MILLISECONDS.sleep(400l);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}