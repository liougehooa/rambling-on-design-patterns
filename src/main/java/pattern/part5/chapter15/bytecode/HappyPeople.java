package pattern.part5.chapter15.bytecode;

import java.util.concurrent.TimeUnit;

/**
 * Date: 2009-11-17
 * Time: 23:44:43
 */
public abstract class HappyPeople {
    public void celebrateSpringFestival() {
        subscribeTicket();
        travel();
        celebrate();
    }

    protected void subscribeTicket() {
        //Buy a ticket...
        System.out.println("Buying a ticket...");
        try {//try to sleep for a while...
            TimeUnit.MILLISECONDS.sleep(100l);
        } catch (InterruptedException e) {
            //do nothing
        }
    }

    protected abstract void travel();

    protected void celebrate() {
        //Celebrate Chinese New Year...
        System.out.println("Happy Chinese New Year!");
        try {//try to sleep for a while...
            TimeUnit.MILLISECONDS.sleep(300l);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}
