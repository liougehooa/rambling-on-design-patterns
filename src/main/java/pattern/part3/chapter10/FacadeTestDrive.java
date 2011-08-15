package pattern.part3.chapter10;

/**
 * User: liujih
 * Date: Mar 23, 2011
 * Time: 8:17:04 PM
 */
public class FacadeTestDrive {
     public static void main(String[] args) {
        Cashier cashier = new Cashier();
        Cook cook = new Cook();
        HotelReceptionist hotelReceptionist = new HotelReceptionist();
        Waitress waitress = new Waitress();
        Assistant assistant = new Assistant(hotelReceptionist, cook, waitress, cashier);

        Boss boss = new Boss(assistant);

        boss.treat();
    }
}
