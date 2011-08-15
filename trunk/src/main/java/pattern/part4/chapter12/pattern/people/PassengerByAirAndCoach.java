package pattern.part4.chapter12.pattern.people;

import pattern.part4.chapter12.pattern.travellable.ByAir;
import pattern.part4.chapter12.pattern.travellable.ByCoach;
import pattern.part4.chapter12.pattern.travellable.Travellable;

/**
 * Date: 2009-11-18
 * Time: 0:23:43
 */
public class PassengerByAirAndCoach extends HappyPeople {
    private Travellable first;
    private Travellable second;

    public PassengerByAirAndCoach() {
        first = new ByAir();
        second = new ByCoach();
    }

    @Override
    protected void travel() {
        first.travel();
        second.travel();
    }
}