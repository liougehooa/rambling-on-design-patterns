package pattern.part5.chapter15.interceptor;

import pattern.part5.chapter15.interceptor.framework.BusinessObjectProxy;

/**
 * User: liujih
 * Date: Mar 29, 2011
 * Time: 3:59:04 PM
 */
public class InterceptorTestDrive {
    public static void main(String[] args) throws Exception {
        NaiveInterceptorFrameWork.configure();

        BusinessObjectProxy subscribeTicket = NaiveInterceptorFrameWork.lookup("subscribeTicket");
        BusinessObjectProxy travel = NaiveInterceptorFrameWork.lookup("travel");
        BusinessObjectProxy celebrate = NaiveInterceptorFrameWork.lookup("celebrate");

        subscribeTicket.execute();
        travel.execute();
        celebrate.execute();
    }
}
