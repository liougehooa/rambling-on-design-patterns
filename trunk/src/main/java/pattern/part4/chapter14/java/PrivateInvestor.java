package pattern.part4.chapter14.java;

import java.util.Observable;
import java.util.Observer;

/**
 * Date: 2010-8-15
 * Time: 12:24:54
 */
public class PrivateInvestor implements Observer {
    private String name;
    private float maxPrice;
    private float minPrice;

    public PrivateInvestor(String name, float maxPrice, float minPrice, Stock stock) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        stock.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        float price = (Float) arg;
        if (price > maxPrice) {
            System.out.printf("%s is buying 500 shares...\n", name);
        }

        if (price < minPrice) {
            System.out.printf("%s is selling 1000 stocks...\n", name);
        }
    }
}