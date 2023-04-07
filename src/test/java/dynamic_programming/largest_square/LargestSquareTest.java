package dynamic_programming.largest_square;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dynamic_programming.largest_square.LargestSquare.getLargestSquare;
import static org.junit.jupiter.api.Assertions.*;

class LargestSquareTest {

    @Test
    @DisplayName("LargestSquareTest")
    public void getLargestSquareTest() {
        int result;

        result = getLargestSquare(new int[][]{
                {0, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
        });
        assertEquals(4, result);

        result = getLargestSquare(new int[][]{
                {0, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
        });
        assertEquals(9, result);

        result = getLargestSquare(new int[][]{
                {0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 1},
        });
        assertEquals(16, result);


        result = getLargestSquare(new int[][]{
                {0, 0},
                {0, 1},
        });
        assertEquals(1, result);

        result = getLargestSquare(new int[][]{
                {1}
        });
        assertEquals(1, result);

        result = getLargestSquare(new int[][]{
                {0}
        });
        assertEquals(0, result);

        result = getLargestSquare(new int[0][0]);
        assertEquals(0, result);
    }
}