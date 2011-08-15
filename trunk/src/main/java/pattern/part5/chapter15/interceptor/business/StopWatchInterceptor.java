package pattern.part5.chapter15.interceptor.business;

import pattern.part5.chapter15.Stopwatch;
import pattern.part5.chapter15.interceptor.framework.Interceptor;
import pattern.part5.chapter15.interceptor.framework.Invocation;

/**
 * User: liujih
 * Date: Mar 29, 2011
 * Time: 4:18:18 PM
 */
public class StopWatchInterceptor implements Interceptor {
    private Stopwatch stopwatch = new Stopwatch();

    @Override
    public Object intercept(Invocation invocation) throws Exception {
        stopwatch.reset();

        //invoke
        Object result = invocation.invoke();

        stopwatch.info("Method " + invocation.getProxy().getConfig().getMethodName() + "() used");
        return result;
    }
}
