package searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static searching.FindDuplicates.*;

class FindDuplicatesTest {
    static char[] test1Chars = {'1', '☺', '☺', '2', '0', 'a', '1', 'a', '0', '0', 'ы', 'ы', ' ', ' '};
    static char[] test2Chars = {'1', '1'};
    static char[] test3Chars = {'', '', '', '', '煮', '煮'};
    static char[] zeroChars = {};


    @DisplayName("Тест метода поиска дубликатов")
    @Test
    void findDuplicateCharsTest() {
        assertArrayEquals(new char[]{' ', '1', 'a', 'ы', '☺'}, findDuplicateChars(test1Chars));
        assertArrayEquals(new char[]{'1'}, findDuplicateChars(test2Chars));
        assertArrayEquals(new char[]{'', '', '煮'}, findDuplicateChars(test3Chars));
        assertArrayEquals(new char[]{}, findDuplicateChars(zeroChars));
    }
}