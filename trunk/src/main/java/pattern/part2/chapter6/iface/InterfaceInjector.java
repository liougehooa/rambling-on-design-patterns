package pattern.part2.chapter6.iface;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Mar 16, 2011
 * Time: 12:41:25 AM
 */
public class InterfaceInjector {
    private static InterfaceInjector injector;
    private Map<Class, Object> services = new HashMap<Class, Object>();

    public static void configure() {
        load(new InterfaceInjector());
    }

    public static <T> T getInstance(Class<T> clazz) {
        return injector.loadService(clazz);
    }

    private static void load(InterfaceInjector container) {
        InterfaceInjector.injector = container;
    }

    @SuppressWarnings("unchecked")
    private <T> T loadService(Class<T> clazz) {
        Object service = injector.services.get(clazz);
        if (service != null) {
            return (T) service;
        }

        try {
            service = clazz.newInstance();
            if (service instanceof ServiceAware) {
                ((ServiceAware) service).injectService(new ServiceImpl());
            }
            injector.services.put(clazz, service);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) service;
    }
}
