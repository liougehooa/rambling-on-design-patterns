package pattern.part4.chapter14.pattern;

/**
 * Date: 2010-8-15
 * Time: 12:24:54
 */
public class PrivateInvestor implements StockBuyer {
    private String name;
    private float maxPrice;
    private float minPrice;

    public PrivateInvestor(String name, float maxPrice, float minPrice, Stock stock) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        stock.addBuyers(this);
    }

    @Override
    public void update(float price) {
        if (price > maxPrice) {
            System.out.printf("%s is buying 500 shares...\n", name);
        }

        if (price < minPrice) {
            System.out.printf("%s is selling 1000 stocks...\n", name);
        }
    }
}
