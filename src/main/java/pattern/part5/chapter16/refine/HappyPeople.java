package pattern.part5.chapter16.refine;

/**
 * Date: 2009-11-17
 * Time: 23:44:43
 */
public class HappyPeople {
    private Travel travel;

    public HappyPeople(Travel travel) {
        this.travel = travel;
    }

    public void celebrateSpringFestival() {
        subscribeTicket();
        travel.travel();
        celebrate();
    }

    private void subscribeTicket() {
        //Buying ticket...
        System.out.println("Buying ticket...");
    }

    private void celebrate() {
        //Celebrating Chinese New Year...
        System.out.println("Happy Chinese New Year!");
    }
    
}