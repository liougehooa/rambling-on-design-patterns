package pattern.part4.chapter13.pattern;

/**
 * Date: 2010-7-25
 * Time: 20:01:54
 */
public class GreenState implements State {
    @Override
    public void push(PaintBoard paintBoard) {
        paintBoard.setState(new BlueState());
    }

    @Override
    public void pull(PaintBoard paintBoard) {
        paintBoard.setState(new RedState());
    }

    @Override
    public String name() {
        return "GREEN";
    }
}