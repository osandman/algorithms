package recursion.fill_paint;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor, boolean allAround) {
        if (desiredColor == null) return false;
        if ((y > image.length - 1) || (x > image[0].length - 1)
            || (y < 0) || (x < 0)) {
            return false;
        }
        if (desiredColor.equals(image[y][x])) {
            return false;
        }
        Color baseColor = image[y][x];
        if (allAround) {
            fillAround(image, x, y, desiredColor, baseColor);
        } else {
            fillFourDirection(image, x, y, desiredColor, baseColor);
        }
        return true;
    }

    private void fillFourDirection(Color[][] image, int x, int y, Color desiredColor, Color toFill) {
        image[y][x] = desiredColor;
//        Main.printPaint(image);
        if (x - 1 >= 0 && image[y][x - 1] == (toFill)) {
            fillFourDirection(image, x - 1, y, desiredColor, toFill);
        }
        if (x + 1 < image[0].length && image[y][x + 1] == toFill) {
            fillFourDirection(image, x + 1, y, desiredColor, toFill);
        }
        if (y - 1 >= 0 && image[y - 1][x] == toFill) {
            fillFourDirection(image, x, y - 1, desiredColor, toFill);
        }
        if (y + 1 < image.length && image[y + 1][x] == toFill) {
            fillFourDirection(image, x, y + 1, desiredColor, toFill);
        }
    }

    private void fillAround(Color[][] image, int x, int y, Color desiredColor, Color toFill) {
        image[y][x] = desiredColor;
//        Main.printPaint(image);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((y + i > image.length - 1) || (x + j > image[0].length - 1)
                    || (y + i < 0) || (x + j < 0)) {
                    continue;
                }
                if (!image[y + i][x + j].equals(desiredColor) && image[y + i][x + j] == toFill){
                    fillAround(image, x + j, y + i, desiredColor, toFill);
                }
            }
        }
    }
}
