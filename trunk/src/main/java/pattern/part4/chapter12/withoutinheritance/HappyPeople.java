package pattern.part4.chapter12.withoutinheritance;

import pattern.part4.chapter12.withoutinheritance.travellable.Travellable;

import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2009-11-17
 * Time: 23:44:43
 */
public class HappyPeople {
    private List<Travellable> transportationList;

    public HappyPeople() {
        transportationList = new LinkedList<Travellable>();
    }

    public void celebrateSpringFestival() {
        subscribeTicket();
        travel();
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

    public void travel() {
        for (Travellable travel : transportationList) {
            travel.travel();
        }
    }
    
    public void addTransportation(Travellable transportation) {
        transportationList.add(transportation);
    }

    public void getTransportation(int index) {
        transportationList.get(index);
    }

    public void removeTransportation(Travellable transportation) {
        transportationList.remove(transportation);
    }
    
}