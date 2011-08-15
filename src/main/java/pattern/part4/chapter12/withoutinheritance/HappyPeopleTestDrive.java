package pattern.part4.chapter12.withoutinheritance;

import pattern.part4.chapter12.withoutinheritance.travellable.ByAir;
import pattern.part4.chapter12.withoutinheritance.travellable.ByCoach;
import pattern.part4.chapter12.withoutinheritance.travellable.ByTrain;

/**
 * Date: 2009-11-18
 * Time: 0:42:25
 */
public class HappyPeopleTestDrive {
    public static void main(String[] args) {
        HappyPeople passengerByAir = new HappyPeople();
        passengerByAir.addTransportation(new ByAir());

        HappyPeople passengerByCoach = new HappyPeople();
        passengerByCoach.addTransportation(new ByCoach());

        HappyPeople passengerByTrain = new HappyPeople();
        passengerByTrain.addTransportation(new ByTrain());

        HappyPeople passengerByAirAndCoach = new HappyPeople();
        passengerByAirAndCoach.addTransportation(new ByAir());
        passengerByAirAndCoach.addTransportation(new ByCoach());

        System.out.println("Let's Go Home For A Grand Family Reunion...");
        System.out.println("Tom is going home:");
        passengerByAir.celebrateSpringFestival();
        System.out.println("\nRoss is going home:");
        passengerByCoach.celebrateSpringFestival();
        System.out.println("\nCatherine is going home:");
        passengerByTrain.celebrateSpringFestival();
        System.out.println("\nJennifer is going home:");
        passengerByAirAndCoach.celebrateSpringFestival();
    }
}