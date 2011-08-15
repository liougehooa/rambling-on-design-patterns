package pattern.part5.chapter15.dynamicproxy;

/**
 * Date: Jul 1, 2010
 * Time: 6:22:00 PM
 */

import pattern.part5.chapter15.Stopwatch;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.lang.reflect.Proxy.newProxyInstance;

public class HappyPeopleHandler implements InvocationHandler {
    private HappyPeople delegate;
    private final Stopwatch stopwatch = new Stopwatch();
    private static Set<String> methodNames;


    static {
        methodNames = new HashSet<String>();
        methodNames.add("subscribeTicket");
        methodNames.add("travel");
        methodNames.add("celebrate");
        methodNames = Collections.<String>unmodifiableSet(methodNames);
    }

    public static IHappyPeople newProxy(HappyPeople delegate) {
        IHappyPeople o = (IHappyPeople) newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getSuperclass().getInterfaces(),
                new HappyPeopleHandler(delegate));

        return o;
    }

    public HappyPeopleHandler(HappyPeople delegate) {
        this.delegate = delegate;
    }

    //logic of pointcut, to check which methods should be weaved
    private boolean isMethodQualified(Method method) {
        if (method == null)return false;
        return methodNames.contains(method.getName());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        try {
            boolean intercept = isMethodQualified(method);

            if (intercept) {
                stopwatch.reset();
            }

            result = method.invoke(delegate, args);

            if (intercept) {
                stopwatch.info("Method " + method.getName() + "() used");
            }
        } catch (Exception e) {//handle exceptions...
            e.printStackTrace();
        }
        return result;
    }
}