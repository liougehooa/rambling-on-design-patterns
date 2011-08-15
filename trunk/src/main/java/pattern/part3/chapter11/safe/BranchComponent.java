package pattern.part3.chapter11.safe;

/**
 * Date: 2010-2-20
 * Time: 16:26:38
 */
public abstract class BranchComponent {
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDiscription() {
        throw new UnsupportedOperationException();
    }

    public void display() {
        throw new UnsupportedOperationException();
    }
}
