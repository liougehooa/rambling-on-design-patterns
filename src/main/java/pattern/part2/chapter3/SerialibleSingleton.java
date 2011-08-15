package pattern.part2.chapter3;

import java.io.Serializable;

/**
 * Date: 2009-11-1
 * Time: 23:30:26
 */
public class SerialibleSingleton implements Serializable {
    private static final long serialVersionUID = -6099617126325157499L;
    static SerialibleSingleton singleton = new SerialibleSingleton();

    private SerialibleSingleton() {
    }

    public static SerialibleSingleton getInstance() {
        return singleton;
    }

    // This method is called immediately after an object of this class is deserialized.
    // This method returns the singleton instance.

    private Object readResolve() {
        return singleton;
    }
}