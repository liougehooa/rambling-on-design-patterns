package pattern.part5.chapter16.refine;

import pattern.part5.chapter16.refine.travellable.Travellable;

import java.util.LinkedList;
import java.util.List;

/**
 * Date: Jan 25, 2011
 * Time: 8:44:14 PM
 */
public class Travel {
    private List<Travellable> transportationList;

    public Travel() {
        transportationList = new LinkedList<Travellable>();
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

    public void travel() {
        for (Travellable travel : transportationList) {
            travel.travel();
        }
    }
}