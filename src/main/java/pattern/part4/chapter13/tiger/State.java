package pattern.part4.chapter13.tiger;

/**
 * Date: 2010-7-25
 * Time: 17:34:29
 */
public interface State {
    void push(PaintBoard paintBoard);

    void pull(PaintBoard paintBoard);

    String name();
}