package pattern.part4.chapter14.pattern;

/**
 * Date: 2010-8-15
 * Time: 12:32:27
 */
public class TestDrive {
    public static void main(String[] args) {
        Stock stock = new Stock(19f);
        InstitutionalInvestor institutionalInvestor = new InstitutionalInvestor("Company E", 20f, 18.5f, stock);
        PrivateInvestor privateInvestor = new PrivateInvestor("Xiao D", 20f, 18.9f, stock);

        stock.setPrice(19.0224f);
        System.out.println();

        stock.setPrice(20.923f);
        System.out.println();

        stock.setPrice(18.8938f);
        System.out.println();

        stock.setPrice(19.9938f);
    }
}