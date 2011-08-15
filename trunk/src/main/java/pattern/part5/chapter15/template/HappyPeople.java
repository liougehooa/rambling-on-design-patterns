package pattern.part5.chapter15.template;

import pattern.part5.chapter15.Stopwatch;

/**
 * Date: Jun 28, 2010
 * Time: 4:30:39 PM
 */
public abstract class HappyPeople {
    private final Stopwatch stopwatch = new Stopwatch();

    public void celebrateSpringFestival() {
        subscribeTicket();
        travel();
        celebrate();
    }

    protected final void subscribeTicket() {
        //Buy a ticket...
        System.out.println("Buying a ticket...");
    }

    protected final void travel() {
        stopwatch.reset();
        onTravel();
        stopwatch.info("Method travel() used");
    }

    protected abstract void onTravel();

    protected final void celebrate() {
        //Celebrate Chinese New Year...
        System.out.println("Happy Chinese New Year!");
    }
}
