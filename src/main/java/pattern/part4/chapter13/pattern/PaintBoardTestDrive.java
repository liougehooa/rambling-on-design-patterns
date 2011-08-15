package pattern.part4.chapter13.pattern;

/**
 * Date: 2010-7-25
 * Time: 18:47:05
 */
public class PaintBoardTestDrive {
    public static void main(String[] args) {
        PaintBoardTestDrive test = new PaintBoardTestDrive();
        PaintBoard paintBoard = new PaintBoard();

        System.out.println("Push Test:");
        System.out.println("Paint board current color:" + paintBoard.getCurrentColor());
        test.pushTest(paintBoard);

        System.out.println("\nPull Test:");
        System.out.println("Paint board current color:" + paintBoard.getCurrentColor());
        test.pullTest(paintBoard);
    }

    public void pushTest(PaintBoard paintBoard) {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s ---push---> ", paintBoard.getCurrentColor());
            paintBoard.push();
            System.out.println(paintBoard.getCurrentColor());
        }
    }

    public void pullTest(PaintBoard paintBoard) {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s ---pull---> ", paintBoard.getCurrentColor());
            paintBoard.pull();
            System.out.println(paintBoard.getCurrentColor());
        }
    }
}