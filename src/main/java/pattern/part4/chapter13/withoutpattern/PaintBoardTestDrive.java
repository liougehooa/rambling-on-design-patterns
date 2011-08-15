package pattern.part4.chapter13.withoutpattern;

/**
 * Date: 2010-7-25
 * Time: 12:02:11
 */
public class PaintBoardTestDrive {
    public static void main(String[] args) {
        PaintBoard paintBoard = new PaintBoard();
        System.out.println("Push Test:");
        System.out.println("Paint board current color:" + paintBoard.getCurrentColor());
        for (int i = 0; i < 3; i++) {
            push(paintBoard);
        }

        System.out.println("\nPull Test:");
        System.out.println("Paint board current color:" + paintBoard.getCurrentColor());
        for (int i = 0; i < 3; i++) {
            pull(paintBoard);
        }
    }

    private static void push(PaintBoard paintBoard) {
        System.out.printf("%s ---push---> ", paintBoard.getCurrentColor());
        paintBoard.push();
        System.out.println(paintBoard.getCurrentColor());
    }

    private static void pull(PaintBoard paintBoard) {
        System.out.printf("%s ---pull---> ", paintBoard.getCurrentColor());
        paintBoard.pull();
        System.out.println(paintBoard.getCurrentColor());
    }
}
