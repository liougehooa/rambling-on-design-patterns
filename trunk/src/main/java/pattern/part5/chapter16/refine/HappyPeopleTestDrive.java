package pattern.part5.chapter16.refine;

import pattern.part5.chapter16.refine.travellable.ByAir;
import pattern.part5.chapter16.refine.travellable.ByCoach;
import pattern.part5.chapter16.refine.travellable.ByTrain;

/**
 * Date: 2009-11-18
 * Time: 0:42:25
 */
public class HappyPeopleTestDrive {
    public static void main(String[] args) {
        Travel travelByAir = new Travel();
        travelByAir.addTransportation(new ByAir());
        HappyPeople passengerByAir = new HappyPeople(travelByAir);

        Travel travelByCoach = new Travel();
        travelByCoach.addTransportation(new ByCoach());
        HappyPeople passengerByCoach = new HappyPeople(travelByCoach);

        Travel travelByTrain = new Travel();
        travelByTrain.addTransportation(new ByTrain());
        HappyPeople passengerByTrain = new HappyPeople(travelByTrain);

        Travel travelByAirAndCoach = new Travel();
        travelByAirAndCoach.addTransportation(new ByAir());
        travelByAirAndCoach.addTransportation(new ByCoach());
        HappyPeople passengerByAirAndCoach = new HappyPeople(travelByAirAndCoach);

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