package various.chain_of_words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * В методе getChain используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова
 * совпадала с первой буквой следующего не учитывая регистр.
 * Каждое слово должно участвовать 1 раз.
 * Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
 * Метод должен возвращать любой правильный вариант при наличии нескольких таковых.
 * Слова разделять пробелом.
 */
public class CreateChain {
    public StringBuilder getChain(String... words) {
        List<String> processList = new ArrayList<>(Arrays.asList(words));
        List<String> initList = new ArrayList<>(processList);
        StringBuilder result = new StringBuilder();

        while (!processList.isEmpty()) {
            for (String word : initList) {
                String currentWord = word;
                while (currentWord != null) {
                    result.append(currentWord).append(" ");
                    processList.remove(currentWord);
                    currentWord = findSecondWord(processList, currentWord);
                }
                if (processList.isEmpty()) break;
                processList = new ArrayList<>(initList);
                result.setLength(0);
            }
            Collections.shuffle(initList);
        }
        return new StringBuilder(result.toString().trim());
    }

    private boolean connectWords(String s1, String s2) {
        return s1.substring(s1.length() - 1)
                .equalsIgnoreCase(s2.substring(0, 1));
    }

    private String findSecondWord(List<String> words, String firstWord) {
        for (String secondWord : words) {
            if (connectWords(firstWord, secondWord)) {
                return secondWord;
            }
        }
        return null;
    }

    public StringBuilder getChainNotMineForTest(String... words) {
        List<Integer> indlist = new ArrayList<>();
        List<String> reslist = new ArrayList<>();
        List<String> clonewords = new ArrayList<>();

        int i, k = 0, count=0;
        String strend = "", strbeg = "";
        while (reslist.size() < words.length) {

            Collections.addAll(clonewords, words);
            reslist.add(words[k]);
            indlist.add(k);
            clonewords.remove(words[k]);

            // конец первого слова
            strend = words[k].substring(words[k].length() - 1);

            while (true) {
                //произвольный индекс [0, words.length)
                i = (int) (Math.random() * words.length);
                if (!indlist.contains(i)) {
                    //начало другого слова
                    strbeg = words[i].substring(0, 1).toLowerCase();
                    if (strend.equals(strbeg)) {
                        reslist.add(words[i]);
                        clonewords.remove(words[i]);
                        indlist.add(i);
                        strend = reslist.get(reslist.size() - 1).substring(reslist.get(reslist.size() - 1).length() - 1);
                    }
                }
                if (reslist.size()== words.length) break;
                else
                {
                    for (String s: clonewords) {
                        if (s.substring(0,1).toLowerCase().equals(strend)) count++;
                    }
                    if (count==0) {
                        reslist.clear();
                        indlist.clear();
                        clonewords.clear();
                        break;
                    }
                    count=0;
                }
            }
            if (k==words.length-1) k=0; else k++;

        }
        return new StringBuilder(reslist.toString().substring(1, reslist.toString().length() - 1).replaceAll(",", ""));
    }
}
