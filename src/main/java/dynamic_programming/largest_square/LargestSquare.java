package dynamic_programming.largest_square;

import java.util.Arrays;

/**
 * Реализуй метод int getLargestSquare(int[][] matrix), возвращающий площадь самого большого квадрата
 * состоящего из единиц в двумерном массиве matrix.
 * Массив matrix заполнен только нулями и единицами.
 */
public class LargestSquare {
    public static void main(String[] args) {
        System.out.println("expected 9: " + getLargestSquare(new int[][]
                {
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}
                }
        ));
    }

    public static int getLargestSquare(int[][] matrix) {
        int maxLength = 0;
        boolean oneIsPresent = Arrays.stream(matrix).flatMapToInt(Arrays::stream)
                .anyMatch(el -> el == 1);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                int prev = matrix[i][j - 1];
                int up = matrix[i - 1][j];
                int upDiag = matrix[i - 1][j - 1];
                int current = matrix[i][j];
                if (prev == 0 || up == 0 || upDiag == 0 || current == 0) continue;
                if (prev == up) {
                    matrix[i][j] = upDiag + 1;
                    maxLength = Math.max(maxLength, matrix[i][j]);
                } else matrix[i][j] = Math.min(prev, up) + 1;
            }
        }
        return maxLength > 0 ? maxLength * maxLength : (oneIsPresent ? 1 : 0);
    }
}
