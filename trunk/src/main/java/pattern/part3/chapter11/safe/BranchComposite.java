package pattern.part3.chapter11.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2010-2-20
 * Time: 16:27:00
 */
public class BranchComposite extends BranchComponent {
    private String name;
    private String discription;
    private List<BranchComponent> childrenBranch;

    public BranchComposite(String name, String discription) {
        this.name = name;
        this.discription = discription;
        childrenBranch = new ArrayList<BranchComponent>();
    }

    public void display() {
        System.out.printf("%s: %s\n", name, discription);
        for (BranchComponent child : childrenBranch) {
            child.display();
        }
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public void add(BranchComponent child) {
        childrenBranch.add(child);
    }

    public void remove(BranchComponent child) {
        childrenBranch.remove(child);
    }

    public BranchComponent getChild(int index) {
        return childrenBranch.get(index);
    }
}
