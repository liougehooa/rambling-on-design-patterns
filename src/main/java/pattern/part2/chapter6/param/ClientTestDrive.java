package pattern.part2.chapter6.param;

/**
 * Date: Nov 23, 2010
 * Time: 7:35:54 AM
 *|| */
public class ClientTestDrive {
    public void testDoSomething() {
        MockService mockService = new MockService();
        Client client = new Client();

        client.doSomething(mockService);
        assertEquals(mockService.isExecuted(), true, "Test failed");
    }

    public static void main(String[] args) {
        new ClientTestDrive().testDoSomething();
    }

    private static void assertEquals(boolean actual, boolean expected, String message) {
        if (actual != expected) throw new IllegalArgumentException(message);
    }

    private static class MockService implements Service {
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