package process_strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqSubstringTest {

    static String testStr1 = "qweRtyRasdfg";
    static String testStr2 = "";
    static String testStr3 = null;
    static String testStr4 = "32321";

    @Test
    public void getUniqSubstringTest() {
        assertEquals("tyRasdfg", UniqSubstring.getMaxUniqSubString(testStr1));
        assertEquals("", UniqSubstring.getMaxUniqSubString(testStr2));
        assertEquals("", UniqSubstring.getMaxUniqSubString(testStr3));
        assertEquals("321", UniqSubstring.getMaxUniqSubString(testStr4));
    }

}