package parsing.roman_numerals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Конвертер римских чисел в Integer.
 * <p>
 * В настоящее время в римской системе счисления используются следующие знаки:
 * <p>
 * I = 1; V = 5; X = 10; L = 50; C = 100; D = 500; M = 1000.
 * Все целые числа от 1 до 3999 (MMMCMXCIX) записываются с помощью приведенных выше цифр. При этом:
 * <p>
 * 1. если большая цифра стоит перед меньшей, они складываются:
 * VI = 5 + 1 = 6; XV = 10 + 5 = 15; LX = 50 + 10 = 60; CL = 100 + 50 = 150;
 * <p>
 * 2. если меньшая цифра стоит перед большей (в этом случае она не может повторяться), то меньшая вычитается из большей;
 * вычитаться могут только цифры, обозначающие 1 или степени 10; уменьшаемым может быть только цифра, ближайшая
 * в числовом ряду к вычитаемой:
 * IV = 5 - 1 = 4; IX = 10 - 1 = 9; XL = 50 - 10 = 40; XC = 100 - 10 = 90;
 * <p>
 * 3. цифры V, L, D не могут повторяться; цифры I, X, C, M могут повторяться не более трех раз подряд:
 * VIII = 8; LXXX = 80; DCCC = 800; MMMD = 3500.
 */
public class RomanNumeralsParser {
    public final static HashMap<String, Integer> romanSymbols = new HashMap<>();

    static {
        romanSymbols.put("I", 1);
        romanSymbols.put("V", 5);
        romanSymbols.put("X", 10);
        romanSymbols.put("L", 50);
        romanSymbols.put("C", 100);
        romanSymbols.put("D", 500);
        romanSymbols.put("M", 1000);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        String[] input = s.toUpperCase().split("");
        int result = 0;
        int temp = 0;
        for (String value : input) {
            int next = romanSymbols.get(value);
            if ((temp < next)
                && (String.valueOf(temp).replace("0", "").equals("1"))) {
                next = next - 2 * temp;
            }
            result += next;
            temp = next;
        }
        return result;
    }
}
