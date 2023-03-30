package process_strings;

import help.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

public class UniqSubstring {

    public static void main(String[] args) {
        String input = Generator.getRandomStringFromBigInteger(100);
        System.out.print(input + " " + getMaxUniqSubString(input));
    }

    public static String getMaxUniqSubString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        Set<Character> chars = new LinkedHashSet<>();
        String maxSubstr = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            boolean wasAdd = chars.add(ch);
            if (wasAdd) {
                if (chars.size() > maxSubstr.length()) {
                    maxSubstr = chars.toString().replaceAll("[\\[\\], ]", "");
                }
            } else {
                i -= chars.size();
                chars.clear();
            }
        }
        return maxSubstr;
    }
}
