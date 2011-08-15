package pattern.part3.chapter8.dynamic;

/**
 * Date: Dec 20, 2010
 * Time: 7:40:57 PM
 *|| */
public class IncreaseImpl implements Increasable {
    private static final int max = 100000;
    private long count;

    @Override
    public void increase(int delta) {
        count = 0;
        for (int i = 0; i < max; i++) {
            count += delta;
        }

        if (count % delta != 0) {
            throw new IllegalStateException("Count state is illegal!");
        }
    }
}
