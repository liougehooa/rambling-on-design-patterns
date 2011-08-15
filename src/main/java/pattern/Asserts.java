package pattern;

/**
 * Date: Nov 23, 2010
 * Time: 7:50:55 AM
 **/
public abstract class Asserts {

    /**
     * Asserts that a condition is true. If it isn't it throws
     * an IllegalArgumentException.
     */
    public static void assertTrue(boolean condition) {
        assertTrue(condition, null);
    }

    /**
     * Asserts that a condition is true. If it isn't, it throws
     * an IllegalArgumentException with the given message.
     */
    public static void assertTrue(boolean condition, String message) {
        if (!condition) fail(message);
    }

    /**
     * Asserts that two Boolean Objects are equal. If they are not
     * an IllegalArgumentException is thrown with the given message.
     */
    public static void assertEquals(Boolean actual, Boolean expected, String message) {
        assertEquals((Object) actual, (Object) expected, message);
    }

    /**
     * Asserts that two Boolean Objects are equal.
     */
    public static void assertEquals(Boolean actual, Boolean expected) {
        assertEquals((Object) actual, (Object) expected, null);
    }

    /**
     * Asserts that two Long Objects are equal. If they are not
     * an IllegalArgumentException is thrown with the given message.
     */
    public static void assertEquals(Long actual, Long expected, String message) {
        assertEquals((Object) actual, (Object) expected, message);
    }

    /**
     * Asserts that two Long Objects are equal.
     */
    public static void assertEquals(Long actual, Long expected) {
        assertEquals((Object) actual, (Object) expected, null);
    }

    /**
     * Asserts that two Integer Objects are equal. If they are not
     * an IllegalArgumentException is thrown with the given message.
     */
    public static void assertEquals(Integer actual, Integer expected, String message) {
        assertEquals((Object) actual, (Object) expected, message);
    }

    /**
     * Asserts that two Integer Objects are equal. If they are not
     * an IllegalArgumentException is thrown with the given message.
     */
    public static void assertEquals(Integer actual, Integer expected) {
        assertEquals((Object) actual, (Object) expected, null);
    }

    /**
     * Asserts that two Strings are equal. If they are not
     * an IllegalArgumentException is thrown with the given message.
     */
    public static void assertEquals(String actual, String expected, String message) {
        assertEquals((Object) actual, (Object) expected, message);
    }

    /**
     * Asserts that two Strings are equal.
     */
    public static void assertEquals(String actual, String expected) {
        assertEquals(actual, expected, null);
    }

    /**
     * Asserts that two Objects are equal. If they are not
     * an IllegalArgumentException is thrown with the given message.
     */
    public static void assertEquals(Object actual, Object expected, String message) {
        if (expected == null && actual == null) return;
        if (expected != null && expected.equals(actual)) return;
        fail(expected, actual, message);
    }

    /**
     * Asserts that two Objects are equal.
     */
    public static void assertEquals(Object actual, Object expected) {
        assertEquals(actual, expected, null);
    }

    /**
     * format the given message
     */
    public static String format(Object expected, Object actual, String message) {
        String formatted = "";
        if (message != null) formatted = message + " ";
        return formatted + "expected:[" + expected + "] but was:[" + actual + "]";
    }

    /**
     * Throw an IllegalArgumentException with the given message.
     */
    static public void fail(Object expected, Object actual, String message) {
        throw new IllegalArgumentException(format(expected, actual, message));
    }

    /**
     * Throw an IllegalArgumentException with the given message.
     */
    static public void fail(String message) {
        throw new IllegalArgumentException(message);
    }
}
