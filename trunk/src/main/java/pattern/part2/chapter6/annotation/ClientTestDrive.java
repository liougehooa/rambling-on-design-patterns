package pattern.part2.chapter6.annotation;

/**
 * Date: Nov 23, 2010
 * Time: 7:35:54 AM
 *|| */
public class ClientTestDrive {
    public void testDoSomething() {
        MockService1 mockService1 = new MockService1();
        Client client = new Client(mockService1);

        client.doSomething();
        assertEquals(mockService1.isExecuted(), true, "Test failed");
    }

    public static void main(String[] args) {
        new ClientTestDrive().testDoSomething();
    }

    private static void assertEquals(boolean actual, boolean expected, String message) {
        if (actual != expected) throw new IllegalArgumentException(message);
    }

    private static class MockService1 implements Service1 {
        private boolean executed;

        public boolean isExecuted() {
            return executed;
        }

        @Override
        public void execute() {
            executed = true;
        }
    }
}