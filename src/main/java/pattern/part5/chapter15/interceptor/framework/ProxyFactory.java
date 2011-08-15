package pattern.part5.chapter15.interceptor.framework;

/**
 * User: liujih
 * Date: Mar 29, 2011
 * Time: 3:46:10 PM
 */
public class ProxyFactory {
    public static BusinessObjectProxy createProxy(Invocation invocation, Config config) {
        BusinessObjectProxy proxy = new BusinessObjectProxy(invocation, config);
        invocation.init(proxy);
        return proxy;
    }
}
