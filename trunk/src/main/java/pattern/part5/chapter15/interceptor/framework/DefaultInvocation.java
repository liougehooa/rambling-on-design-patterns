package pattern.part5.chapter15.interceptor.framework;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * User: liujih
 * Date: Mar 29, 2011
 * Time: 3:19:26 PM
 */
public class DefaultInvocation implements Invocation {
    private List<Interceptor> interceptorList = new LinkedList<Interceptor>();
    private Iterator<Interceptor> interceptors;
    private Object businessObject;
    private BusinessObjectProxy proxy;

    public DefaultInvocation(Object businessObject) {
        this.businessObject = businessObject;

    }

    @Override
    public void init(BusinessObjectProxy proxy) {
        this.proxy = proxy;
        interceptors = interceptorList.iterator();
    }

    @Override
    public void addInterceptor(Interceptor interceptor) {
        interceptorList.add(interceptor);
    }


    @Override
    public void removeInterceptor(Interceptor interceptor) {
        interceptorList.remove(interceptor);
    }


    @Override
    public Object invoke() throws Exception {
        //other logic...
        Object result = null;
        //Traverse all interceptors
        try {
            if (interceptors.hasNext()) {
                Interceptor interceptor = interceptors.next();
                interceptor.intercept(this);
            } else {
                //To invoke real business object's method
                result = invokeBusinessObjectMethod();
            }
        } catch (Exception e) {
            throw e;
        }

        //other logic...
        return result;
    }

    @Override
    public BusinessObjectProxy getProxy() {
        return proxy;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Object invokeBusinessObjectMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = proxy.getConfig().getMethodName();
        return businessObject.getClass().getMethod(methodName).invoke(businessObject);
    }
}
