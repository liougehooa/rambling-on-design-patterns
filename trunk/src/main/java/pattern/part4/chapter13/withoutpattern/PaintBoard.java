package pattern.part4.chapter13.withoutpattern;

/**
 * Date: 2010-7-25
 * Time: 11:14:44
 */
public class PaintBoard {
    private Color state = Color.RED;

    public String getCurrentColor() {
        return state.name();
    }

    public void push() {
        switch (state) {
            case RED:
                state = Color.GREEN;
                break;
            case BLUE:
                state = Color.RED;
                break;
            case GREEN:
                state = Color.BLUE;
                break;
            default:
                throw new RuntimeException("Invalid state when pushing");
        }
    }

    public void pull() {
        switch (state) {
            case RED:
                state = Color.BLUE;
                break;
            case BLUE:
                state = Color.GREEN;
                break;
            case GREEN:
                state = Color.RED;
                break;
            default:
                throw new RuntimeException("Invalid state when pulling");
        }
    }
}
