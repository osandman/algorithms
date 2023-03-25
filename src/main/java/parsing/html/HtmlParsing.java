package parsing.html;

import java.io.*;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class HtmlParsing {
    public static void main(String[] args) {
        findClosableTags();
    }

    /**
     * Печатает на консоль все теги, которые соответствуют заданному в строке {@code findTag} <p>
     * Каждый тег на новой строке, порядок соответсвует порядку следования в файле заданному {@code filName} <p>
     * Работает только с закрывающимися тэгами
     */
    public static void findClosableTags() {
        String findTag = "script";
        String filName = "src\\main\\resources\\index.html";
        StringBuilder allFile = new StringBuilder();
        Map<Integer, Integer> pairTags = new TreeMap<>();
        Stack<Integer> startTags = new Stack<>();
        try (FileReader fileReader = new FileReader(filName)) {
            while (fileReader.ready()) {
                allFile.append((char) fileReader.read());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String allWords = allFile.toString().replaceAll("\\r\\n", "");
        int index = 0;
        int findIndexStart;
        int findIndexEnd = 0;
        while (findIndexEnd != -1) {
            findIndexStart = allWords.indexOf("<" + findTag, index);
            findIndexEnd = allWords.indexOf("</" + findTag, index);
            if (findIndexStart != -1 || findIndexEnd != -1) {
                if (findIndexStart != -1 && findIndexStart < findIndexEnd) {
                    startTags.add(findIndexStart);
                    index = findIndexStart + 1;
                } else if (findIndexEnd != -1) {
                    pairTags.put(startTags.pop(), findIndexEnd);
                    index = findIndexEnd + 1;
                }
            } else {
                break;
            }
        }
        for (Map.Entry<Integer, Integer> pair : pairTags.entrySet()) {
            System.out.println(allWords.substring(pair.getKey(), pair.getValue() + findTag.length() + 3).
                    replaceAll("\\s+", " "));
        }
    }
}
