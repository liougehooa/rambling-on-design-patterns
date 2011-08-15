package pattern.part4.chapter12.pattern;

import pattern.part4.chapter12.pattern.people.HappyPeople;
import pattern.part4.chapter12.pattern.people.PassengerByAirAndCoach;

/**
 * Date: 2009-11-18
 * Time: 0:42:25
 */
public class HappyPeopleTestDrive {
    public static void main(String[] args) {
        HappyPeople passengerByAirAndCoach = new PassengerByAirAndCoach();

        System.out.println("Let's Go Home For A Grand Family Reunion...\n");
        System.out.println("Jennifer is going home:");
        passengerByAirAndCoach.celebrateSpringFestival();
    }
}