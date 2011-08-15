package pattern.part4.chapter13.pattern;

/**
 * Date: 2010-7-25
 * Time: 20:01:17
 */
public class RedState implements State {
    @Override
    public void push(PaintBoard paintBoard) {
        paintBoard.setState(new GreenState());
    }

    @Override
    public void pull(PaintBoard paintBoard) {
        paintBoard.setState(new BlueState());
    }

    @Override
    public String name() {
        return "RED";
    }
}