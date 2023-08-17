package process_strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static process_strings.UniqMaxLenSubstring.getMaxLenUniqSubstring;

class UniqMaxLenSubstringTest {

    @Test
    void oneCharacterTest() {
        assertEquals(1, getMaxLenUniqSubstring("a"));
    }

    @Test
    void manySameCharactersTest() {
        assertEquals(1, getMaxLenUniqSubstring("aaaaaaa"));
    }

    @Test
    void stringVar1Test() {
        assertEquals(3, getMaxLenUniqSubstring("abca"));
    }

    @Test
    void stringVar2Test() {
        assertEquals(4, getMaxLenUniqSubstring("babcadbba"));
    }
}