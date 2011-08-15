package pattern.part3.chapter9;

/**
 * Date: 2010-2-15
 * Time: 12:49:55
 */
public class TestDrive {
    public static void main(String[] args) {
        TestDrive test = new TestDrive();

        IPeg squarePeg = new SquarePeg();
        IRoundPeg roundPeg = new RoundPeg();
        RoundPegAdapter adpater = new RoundPegAdapter(roundPeg);

        System.out.println("Testing square peg...");
        test.testPeg(squarePeg);
        System.out.println("\nTesting square adapter peg...");
        test.testPeg(adpater);

        TwoWayPegAdapter roundPeg2 = new TwoWayPegAdapter(roundPeg);
        TwoWayPegAdapter squarePeg2 = new TwoWayPegAdapter(squarePeg);
        System.out.println("\nTesting 2-way square adapter peg...");
        test.testPeg(roundPeg2);
        System.out.println("\nTesting 2-way round adapter peg...");
        test.testRoundPeg(squarePeg2);
    }

    private void testPeg(IPeg peg) {
        peg.insertIntoHole();
    }

    private void testRoundPeg(IRoundPeg peg) {
        peg.insertIntoRoundHole();
    }
}
