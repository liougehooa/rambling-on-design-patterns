package pattern.part3.chapter11.transparent;

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

    public void add(BranchComponent child) {
        throw new UnsupportedOperationException();
    }

    public void remove(BranchComponent child) {
        throw new UnsupportedOperationException();
    }

    public BranchComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }
}