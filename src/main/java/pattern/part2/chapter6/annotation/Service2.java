package pattern.part2.chapter6.annotation;

import com.google.inject.ImplementedBy;

/**
 * Date: Nov 21, 2010
 * Time: 8:17:20 AM
 *|| */
@ImplementedBy(Service2Impl.class)
public interface Service2 {
    void execute();
}