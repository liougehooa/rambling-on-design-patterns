package pattern.part3.chapter9;

/**
 * Date: 2010-2-15
 * Time: 12:46:32
 */
public class TwoWayPegAdapter implements IRoundPeg, IPeg {
    private IPeg squarePeg;
    private IRoundPeg roundPeg;

    public TwoWayPegAdapter(IPeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    public TwoWayPegAdapter(IRoundPeg roundPeg) {
        this.roundPeg = roundPeg;
    }

    @Override
    public void insertIntoRoundHole() {
        squarePeg.insertIntoHole();
    }

    @Override
    public void insertIntoHole() {
        roundPeg.insertIntoRoundHole();
    }
}