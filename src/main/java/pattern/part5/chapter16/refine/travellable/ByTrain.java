package pattern.part5.chapter16.refine.travellable;

/**
 * Date: Aug 2, 2010
 * Time: 5:28:16 PM
 */
public class ByTrain implements Travellable {
    @Override
    public void travel() {
        //travel logic...
        System.out.println("Travelling by Train...");
    }
}