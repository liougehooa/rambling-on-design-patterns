package pattern.part5.chapter15.bytecode;

import static pattern.part5.chapter15.bytecode.HappyPeopleHandler.newProxy;
/**
 * Date: Jun 28, 2010
 * Time: 5:09:39 PM
 */
public class HappyPeopleTestDrive {
    public static void main(String[] args) {
        HappyPeople passengerByAir = newProxy(new PassengerByAir());
        HappyPeople passengerByCoach = newProxy(new PassengerByCoach());
        HappyPeople passengerByTrain = newProxy(new PassengerByTrain());

        System.out.println("Let's Go Home For A Grand Family Reunion...\n");

        System.out.println("Tom is going home:");
        passengerByAir.celebrateSpringFestival();

        System.out.println("\nRoss is going home:");
        passengerByCoach.celebrateSpringFestival();

        System.out.println("\nCatherine is going home:");
        passengerByTrain.celebrateSpringFestival();
    }
}