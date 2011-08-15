package pattern.part2.chapter6.servicelocator;

import static pattern.Asserts.assertEquals;

/**
 * Date: Nov 22, 2010
 * Time: 11:20:27 PM
 *|| */
public class ClientTestDrive {
    public void testDoSomething() {
        //setup env to test this method
        ServiceLocator.configure();
        Service1 service1 = (Service1) ServiceLocator.lookup("service1");
        MockService1 mockService1 = new MockService1();
        ServiceLocator.registerService("service1", mockService1);

        try {
            new Client().doSomething();
            assertEquals(mockService1.isExecuted(), true, "Test failed");
        } finally {
            ServiceLocator.registerService("service1", service1);
        }
    }

    public static void main(String[] args) {
        new ClientTestDrive().testDoSomething();
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