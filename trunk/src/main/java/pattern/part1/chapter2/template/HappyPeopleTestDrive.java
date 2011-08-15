package pattern.part1.chapter2.template;

/**
 * Date: 2009-11-18
 * Time: 0:42:25
 */
public class HappyPeopleTestDrive {
    public static void main(String[] args) {
        HappyPeople passengerByAir = new PassengerByAir();
        HappyPeople passengerByCoach = new PassengerByCoach();
        HappyPeople passengerByTrain = new PassengerByTrain();

        System.out.println("Let's Go Home For A Grand Family Reunion...\n");

        System.out.println("Tom is going home:");
        passengerByAir.celebrateSpringFestival();

        System.out.println("\nRoss is going home:");
        passengerByCoach.celebrateSpringFestival();

        System.out.println("\nCatherine is going home:");
        passengerByTrain.celebrateSpringFestival();
    }
}