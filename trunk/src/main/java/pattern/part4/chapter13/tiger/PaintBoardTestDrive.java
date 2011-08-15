package pattern.part4.chapter13.tiger;

/**
 * Date: 2010-7-25
 * Time: 18:47:05
 */
public class PaintBoardTestDrive {
    public static void main(String[] args) {
        PaintBoard paintBoard = new PaintBoard();
        System.out.println("Push Test:");
        System.out.println("Paint board current color:" + paintBoard.getCurrentColor());
        for (int i = 0; i < 3; i++) {
            pushTest(paintBoard);
        }

        System.out.println("\nPull Test:");
        System.out.println("Paint board current color:" + paintBoard.getCurrentColor());
        for (int i = 0; i < 3; i++) {
            pullTest(paintBoard);
        }
    }

    private static void pushTest(PaintBoard paintBoard) {
        System.out.printf("%s ---push---> ", paintBoard.getCurrentColor());
        paintBoard.push();
        System.out.println(paintBoard.getCurrentColor());
    }

    private static void pullTest(PaintBoard paintBoard) {
        System.out.printf("%s ---pull---> ", paintBoard.getCurrentColor());
        paintBoard.pull();
        System.out.println(paintBoard.getCurrentColor());
    }
}