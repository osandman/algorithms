package process_strings;

import java.util.HashMap;
import java.util.Map;

public class UniqMaxLenSubstring {
    public static void main(String[] args) {
        String str = "dabcabbecbadaadb"; // 5
        System.out.println(getMaxLenUniqSubstring(str));
    }

    public static int getMaxLenUniqSubstring(String input) {
        int maxLen = 0;
        int startUniqIndex = 0;
        Map<Character, Integer> charIndexes = new HashMap<>();
        for (int currentIndex = 0; currentIndex < input.length(); currentIndex++) {
            char ch = input.charAt(currentIndex);
            if (charIndexes.containsKey(ch)) {
                startUniqIndex = Math.max(startUniqIndex, charIndexes.get(ch) + 1);
            }
            charIndexes.put(ch, currentIndex);
            maxLen = Math.max(maxLen, currentIndex - startUniqIndex + 1);
        }
        return maxLen;
    }
}
