package pattern.part3.chapter11.transparent;

/**
 * Date: 2010-2-20
 * Time: 16:59:38
 */
public class BranchLeaf extends BranchComponent {
    private String name;
    private String discription;

    public BranchLeaf(String name, String discription) {
        this.name = name;
        this.discription = discription;
    }

    public void display() {
        System.out.printf("\t%s: %s\n", name, discription);
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }
}