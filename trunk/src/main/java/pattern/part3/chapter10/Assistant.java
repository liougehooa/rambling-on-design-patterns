package pattern.part3.chapter10;

/**
 * Date: 2010-2-19
 * Time: 0:10:39
 */
public class Assistant {
    private HotelReceptionist hotelReceptionist;
    private Cook cook;
    private Waitress waitress;
    private Cashier cashier;

    public Assistant(HotelReceptionist hotelReceptionist, Cook cook, Waitress waitress, Cashier cashier) {
        this.hotelReceptionist = hotelReceptionist;
        this.cook = cook;
        this.waitress = waitress;
        this.cashier = cashier;
    }

    public void prepareDinner() {
        hotelReceptionist.subscribe();
        waitress.waitForAnOrder();
        cook.cookDish();
    }

    public void endDinner() {
        waitress.serveDishes();
        cashier.check();
    }
}
