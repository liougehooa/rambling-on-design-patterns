package pattern.part5.chapter15.dynamicproxy;

import static pattern.part5.chapter15.dynamicproxy.HappyPeopleHandler.newProxy;

/**
 * Date: Jun 28, 2010
 * Time: 5:09:39 PM
 */
public class HappyPeopleTestDrive {
    public static void main(String[] args) {
        IHappyPeople passengerByAir = newProxy(new PassengerByAir());
        IHappyPeople passengerByCoach = newProxy(new PassengerByCoach());
        IHappyPeople passengerByTrain = newProxy(new PassengerByTrain());

        System.out.println("Let's Go Home For A Grand Family Reunion...\n");

        System.out.println("Tom is going home:");
        passengerByAir.subscribeTicket();
        passengerByAir.travel();
        passengerByAir.celebrate();

        System.out.println("\nRoss is going home:");
        passengerByCoach.subscribeTicket();
        passengerByCoach.travel();
        passengerByCoach.celebrate();

        System.out.println("\nCatherine is going home:");
        passengerByTrain.subscribeTicket();
        passengerByTrain.travel();
        passengerByTrain.celebrate();
    }
}