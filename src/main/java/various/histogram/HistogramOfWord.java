package various.histogram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class HistogramOfWord {
    public static void main(String[] args) {
        String fileName1 = "src/main/resources/poem_Esenin.txt";
        String fileName2 = "src/main/resources/sonnet_Shakespear.txt";
        String input = getStrFromFile(fileName2);
//        String input = "Hello, h world!";
        printWordHistogram(input);
    }

    public static void printWordHistogram(String word) {
        Map<Character, Integer> charsMap = new TreeMap<>();
        char[] chars = word.replaceAll("\\s", "").toLowerCase().toCharArray();
        int maxCount = 0;
        for (char current : chars) {
            if (!charsMap.containsKey(current)) {
                charsMap.put(current, 0);
            }
            charsMap.put(current, charsMap.get(current) + 1);
            maxCount = Math.max(maxCount, charsMap.get(current));
        }
        for (int i = maxCount; i > 0; i--) {
            for (Map.Entry<Character, Integer> current : charsMap.entrySet()) {
                if (current.getValue() >= i) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        charsMap.forEach((k, v) -> System.out.print(k));
    }

    private static String getStrFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(Path.of(fileName).toFile()))) {
            while (br.ready()) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
