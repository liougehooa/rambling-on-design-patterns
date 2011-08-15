package pattern.part1.chapter2.callback;

import java.sql.ResultSet;

/**
 * Date: 2009-11-19
 * Time: 0:14:57
 */
public interface ResultSetHandler<T> {
    public T handle(ResultSet rs);
}
