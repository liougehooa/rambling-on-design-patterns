package pattern.part3.chapter8.remote;

/**
 * Date: Dec 7, 2010
 * Time: 8:38:06 PM
 *|| */
public class ServiceImpl implements Service {
    @Override
    public String hello() {
        return "Server says hello!";
    }
}
