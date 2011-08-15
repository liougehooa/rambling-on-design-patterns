package pattern.part4.chapter12.pattern.people;

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

    protected final void subscribeTicket() {
        //Buying ticket...
        System.out.println("Buying ticket...");
    }

    protected abstract void travel();

    protected final void celebrate() {
        //Celebrating Chinese New Year...
        System.out.println("Happy Chinese New Year!");
    }
}