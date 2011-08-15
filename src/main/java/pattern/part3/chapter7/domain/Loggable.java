package pattern.part3.chapter7.domain;

import java.util.Date;

/**
 * Date: 2009-12-1
 * Time: 23:07:28
 */
public interface Loggable {
    Date getLogTime();

    void setLogTime(Date logTime);
}
