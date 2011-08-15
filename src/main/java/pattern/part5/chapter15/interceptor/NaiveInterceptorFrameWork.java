package pattern.part5.chapter15.interceptor;

import pattern.part5.chapter15.interceptor.business.PassengerByAir;
import pattern.part5.chapter15.interceptor.business.StopWatchInterceptor;
import pattern.part5.chapter15.interceptor.framework.BusinessObjectProxy;
import pattern.part5.chapter15.interceptor.framework.Config;
import pattern.part5.chapter15.interceptor.framework.DefaultInvocation;
import pattern.part5.chapter15.interceptor.framework.Invocation;
import pattern.part5.chapter15.interceptor.framework.ProxyFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * User: liujih
 * Date: Mar 29, 2011
 * Time: 7:40:03 PM
 */
public class NaiveInterceptorFrameWork {
    private static NaiveInterceptorFrameWork context;
    private Map<String, BusinessObjectProxy> services = new HashMap<String, BusinessObjectProxy>();

    public static void configure() {
        load(new NaiveInterceptorFrameWork());

        PassengerByAir passengerByAir = new PassengerByAir();
        Invocation subscribeTicketInvocation = new DefaultInvocation(passengerByAir);
        subscribeTicketInvocation.addInterceptor(new StopWatchInterceptor());
        BusinessObjectProxy subscribeTicket = ProxyFactory.createProxy(subscribeTicketInvocation, new Config("subscribeTicket"));
        context.services.put("subscribeTicket", subscribeTicket);

        Invocation travelInvocation = new DefaultInvocation(passengerByAir);
        travelInvocation.addInterceptor(new StopWatchInterceptor());
        BusinessObjectProxy travel = ProxyFactory.createProxy(travelInvocation, new Config("travel"));
        context.services.put("travel", travel);

        Invocation celebrateInvocation = new DefaultInvocation(passengerByAir);
        celebrateInvocation.addInterceptor(new StopWatchInterceptor());
        BusinessObjectProxy celebrate = ProxyFactory.createProxy(celebrateInvocation, new Config("celebrate"));
        context.services.put("celebrate", celebrate);
    }

    private static void load(NaiveInterceptorFrameWork naiveInterceptorFrameWork) {
        context = naiveInterceptorFrameWork;
    }

    public static BusinessObjectProxy lookup(String proxyName) {
        return context.services.get(proxyName);
    }
}
