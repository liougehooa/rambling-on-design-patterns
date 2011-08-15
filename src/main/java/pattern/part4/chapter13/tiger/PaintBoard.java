package pattern.part4.chapter13.tiger;

/**
 * Date: 2010-7-25
 * Time: 18:09:07
 */
public class PaintBoard {
    private State state = Color.RED;

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
