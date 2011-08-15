package pattern.part5.chapter15.interceptor.framework;

/**
 * User: liujih
 * Date: Mar 29, 2011
 * Time: 3:35:27 PM
 */
public class BusinessObjectProxy {
    private Config config;
    private Invocation invocation;


    public BusinessObjectProxy(Invocation invocation, Config config) {
        this.config = config;
        this.invocation = invocation;
    }

    public Config getConfig() {
        return config;
    }

    public Object execute() throws Exception {
        //todo
        return invocation.invoke();
    }
}
