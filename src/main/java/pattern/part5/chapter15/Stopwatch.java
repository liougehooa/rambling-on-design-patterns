package pattern.part5.chapter15;

/**
 * Date: Jun 28, 2010
 * Time: 5:00:12 PM
 */
public class Stopwatch {
    private long start = System.currentTimeMillis();

    /**
     * Resets and returns elapsed time in milliseconds.
     */
    public long reset() {
        long now = System.currentTimeMillis();
        try {
            return now - start;
        } finally {
            start = now;
        }
    }

    /**
     * Resets and print elapsed time in milliseconds.
     */
    public void info(String label) {
        System.out.format("%s: %dms\n", label, reset());
    }
}
