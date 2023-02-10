package searching;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public static char[] findDuplicateChars(char[] numbers) {
        int[] symbols = new int[Character.MAX_VALUE];
        List<Character> duplicateList = new ArrayList<>();
        for (char number : numbers) {
            symbols[number]++;
        }
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == 2) {
                duplicateList.add((char) i);
            }
        }
        char[] duplicates = new char[duplicateList.size()];
        for (int i = 0; i < duplicateList.size(); i++) {
            duplicates[i] = duplicateList.get(i);
        }
        return duplicates;
    }
}
