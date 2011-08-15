package pattern.part3.chapter7.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Date: 2009-11-30
 * Time: 23:36:57
 */
public interface GenericRepository<T> {
    void save(T o);

    void update(T o);

    T get(Class<T> clazz, Serializable id);

    void delete(T o);

    List query(String qlString);

    //other methods...
}