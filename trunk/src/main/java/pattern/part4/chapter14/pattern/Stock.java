package pattern.part4.chapter14.pattern;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Date: 2010-8-15
 * Time: 12:01:15
 */
public class Stock {
    private static final float maxGainAndLoss=0.05f;//5%
    private float price;
    private List<StockBuyer> buyers;

    public Stock(float price) {
        this.price = price;
        buyers = new LinkedList<StockBuyer>();
    }

    public void addBuyers(StockBuyer buyer) {
        if (buyer != null) buyers.add(buyer);
    }

    public void removeBuyers(StockBuyer buyer) {
        if (buyer != null) buyers.remove(buyer);
    }

    public void notifyBuyer() {
        for (StockBuyer buyer : buyers) {
            buyer.update(price);
        }
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
            notifyBuyer();
        }
    }
}