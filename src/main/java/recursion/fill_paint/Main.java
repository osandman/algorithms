package recursion.fill_paint;

import static recursion.fill_paint.Color.*;

/**
 * Залей меня полностью
 * В процессе разработки новой версии популярного графического редактора возникла необходимость реализовать
 * заливку области картинки определенным цветом.
 * <p>
 * Реализуй метод paintFill в классе PhotoPaint таким образом, чтобы он возвращал:
 * - false, если цвет начальной точки (координаты приходят в качестве параметров) совпадает с цветом заливки
 * или если начальные координаты выходят за рамки массива.
 * - модифицировал входящий массив и возвращал true, если заливка все же может быть выполнена.
 * <p>
 * Точке с координатами (x, y) соответствует элемент массив с индексом [y][x].
 */

public class Main {
    public static void main(String[] args) {
        Color[][] paint = new Color[][]{
                {ORANGE, ORANGE, INDIGO, BLUE, BLUE, INDIGO, VIOLET},
                {ORANGE, GREEN, VIOLET, BLUE, INDIGO, RED, VIOLET},
                {GREEN, ORANGE, GREEN, BLUE, BLUE, VIOLET, VIOLET},
                {GREEN, YELLOW, BLUE, YELLOW, BLUE, ORANGE, VIOLET},
                {GREEN, ORANGE, YELLOW, BLUE, BLUE, YELLOW, VIOLET}
        };
        printPaint(paint);
        PhotoPaint photoPaint = new PhotoPaint();
        System.out.println("Is filled: " + photoPaint.paintFill(paint, 4, 4, ORANGE, false));
        printPaint(paint);
    }

    public static void printPaint(Color[][] paint) {
        for (int i = 0; i < paint.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < paint[i].length; j++) {
                System.out.printf("%s", colorFormat(paint[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static String colorFormat(Color color) {
        return color + "[*]" + RESET;
    }
}
