package pattern.part4.chapter13.pattern;

/**
 * Date: 2010-7-25
 * Time: 18:09:07
 */
public class PaintBoard {
    private State state = new RedState();
    //other methods and fields…

    public void setState(State state) {
        this.state = state;
    }

    public String getCurrentColor() {
        return state.name();
    }

    public void push() {
        state.push(this);
    }

    public void pull() {
        state.pull(this);
    }
}