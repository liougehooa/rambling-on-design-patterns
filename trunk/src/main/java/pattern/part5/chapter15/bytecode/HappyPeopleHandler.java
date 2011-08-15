package pattern.part5.chapter15.bytecode;

/**
 * Date: Jul 1, 2010
 * Time: 6:22:00 PM
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import pattern.part5.chapter15.Stopwatch;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HappyPeopleHandler implements MethodInterceptor {
    private final Stopwatch stopwatch = new Stopwatch();
    private static Set<String> methodNames;

    static {
        methodNames = new HashSet<String>();
        methodNames.add("subscribeTicket");
        methodNames.add("travel");
        methodNames.add("celebrate");
        methodNames = Collections.<String>unmodifiableSet(methodNames);
    }

    //logic of pointcut, to check which methods should be weaved
    private boolean isMethodQualified(Method method) {
        if (method == null)return false;

        return Modifier.isProtected(method.getModifiers()) && methodNames.contains(method.getName());
    }

    public static HappyPeople newProxy(HappyPeople delegate) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(delegate.getClass());
        enhancer.setCallback(new HappyPeopleHandler());


        HappyPeople o = (HappyPeople)enhancer.create();
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        try {
            boolean intercept = isMethodQualified(method);

            if (intercept) {
                stopwatch.reset();
            }

            result = methodProxy.invokeSuper(o, objects);

            if (intercept) {
                stopwatch.info("Method " + method.getName() + "() used");
            }
        } catch (Exception e) {//handle exceptions...
            e.printStackTrace();
        }
        return result;
    }
}