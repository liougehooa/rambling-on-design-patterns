package pattern.part5.chapter15.interceptor.framework;

/**
 * User: liujih
 * Date: Mar 29, 2011
 * Time: 3:18:42 PM
 */
public interface Invocation {
    void init(BusinessObjectProxy proxy);

    void addInterceptor(Interceptor interceptor);

    void removeInterceptor(Interceptor interceptor);

    Object invoke() throws Exception;

    BusinessObjectProxy getProxy();
}
