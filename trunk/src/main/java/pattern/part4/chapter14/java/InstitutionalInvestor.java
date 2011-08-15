package pattern.part4.chapter14.java;

import java.util.Observable;
import java.util.Observer;

/**
 * Date: 2010-8-15
 * Time: 12:27:49
 */
public class InstitutionalInvestor implements Observer {
    private String name;
    private float maxPrice;
    private float minPrice;

    public InstitutionalInvestor(String name, float maxPrice, float minPrice, Stock stock) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        stock.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        float price = (Float) arg;
        if (price > maxPrice) {
            System.out.printf("%s is selling 100000 stocks...\n", name);
        }

        if (price < minPrice) {
            System.out.printf("%s is buying 20000 shares...\n", name);
        }
    }
}