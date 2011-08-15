package pattern.part3.chapter9;

/**
 * Date: 2010-2-15
 * Time: 12:41:22
 */
public class RoundPegAdapter implements IPeg {
    private IRoundPeg roundPeg;

    public RoundPegAdapter(IRoundPeg roundPeg) {
        this.roundPeg = roundPeg;
    }

    @Override
    public void insertIntoHole() {
        roundPeg.insertIntoRoundHole();
    }
}
