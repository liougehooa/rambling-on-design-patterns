package pattern.part5.chapter15.interceptor.framework;

/**
 * User: liujih
 * Date: Mar 29, 2011
 * Time: 3:16:34 PM
 */
public interface Interceptor {
    Object intercept(Invocation invocation) throws Exception;
}
