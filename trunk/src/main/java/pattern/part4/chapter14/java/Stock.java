package pattern.part4.chapter14.java;

import java.util.Observable;
import static java.lang.Math.abs;

/**
 * Date: 2010-8-15
 * Time: 23:24:22
 */
public class Stock extends Observable {
    private static final float maxGainAndLoss=0.05f;//5%
    private float price;

    public Stock(float price) {
        super();
        this.price = price;
    }

    public void setPrice(float newPrice) {
        if (newPrice < 0) {
            throw new IllegalArgumentException("Price can not be negative!");
        }

        //update price and calculate change...
        float oldPrice = price;
        price = newPrice;
        float gainAndLoss = (newPrice - oldPrice) / oldPrice;//calculate change
        System.out.printf("Previous price: %g. Current price: %g. Loss/Gain: %g%%.\n", oldPrice, newPrice, gainAndLoss*100);

        //if change beyond maxGainAndLoss, notify stock buyers
        if (abs(gainAndLoss) > maxGainAndLoss) {
            setChanged();
            notifyObservers(price);
        }
    }
}