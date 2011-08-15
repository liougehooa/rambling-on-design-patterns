package pattern.part3.chapter9;

/**
 * Date: Dec 23, 2010
 * Time: 4:32:04 PM
 */
public class RoundPegAdapter2 extends RoundPeg implements IPeg {
    @Override
    public void insertIntoHole() {
        super.insertIntoRoundHole();
    }
}
