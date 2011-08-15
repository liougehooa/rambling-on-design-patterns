package pattern.part3.chapter8.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * Date: Dec 20, 2010
 * Time: 7:46:18 PM
 *|| */
public class SynchronizedHandler implements InvocationHandler {
    private Increasable delegate;

    public static Increasable newProxy(Increasable delegate) {
        Increasable o = (Increasable) newProxyInstance(
                                        delegate.getClass().getClassLoader(),
                                        delegate.getClass().getInterfaces(),
                                        new SynchronizedHandler(delegate));
        return o;
    }

    public SynchronizedHandler(Increasable delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        synchronized (delegate) {
            return method.invoke(delegate, args);
        }
    }
}
