package pattern.part3.chapter11.transparent;

/**
 * Date: 2010-2-20
 * Time: 17:12:45
 */
public class TestDrive {
    public static void main(String[] args) {
        BranchComposite china = new BranchComposite("CN", "China Branch");

        BranchComposite shanghai = new BranchComposite("Sh", "Shanghai Branch");
        BranchLeaf huangpu = new BranchLeaf("Hp", "Huangpu Branch");
        BranchLeaf yangpu = new BranchLeaf("Yp", "Yangpu Branch");
        BranchLeaf pudong = new BranchLeaf("Pd", "Pudong Branch");

        BranchComposite beijing = new BranchComposite("Bj", "Beijing Branch");
        BranchLeaf dongcheng = new BranchLeaf("Dc", "Dongcheng Branch");
        BranchLeaf xicheng = new BranchLeaf("Xc", "Xicheng Branch");
        BranchLeaf haidian = new BranchLeaf("Hd", "Haidian Branch");

        shanghai.add(huangpu);
        shanghai.add(yangpu);
        shanghai.add(pudong);

        beijing.add(dongcheng);
        beijing.add(xicheng);
        beijing.add(haidian);

        china.add(shanghai);
        china.add(beijing);

        System.out.println("Displaying the head bank information");
        display(china);

        System.out.println("\nDisplaying Shanghai bank branch information");
        display(shanghai);

        System.out.println("\nDisplaying Pudong bank branch information in Shanghai");
        display(pudong);
    }

    private static void display(BranchComponent branch) {
        branch.display();
    }
}