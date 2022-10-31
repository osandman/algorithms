package various;

import help.Time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FizzBuzz {
    public enum Quiz {
        FIZZ, BUZZ, FIZZBUZZ
    }
    static Time t = new Time();
    public static void main(String[] args) {

        int n = 10000000;
        Random rand = new Random();
        //заполняем ArrayList числами от 0 до 100, количество элементов = n
        List<Integer> intList = rand.ints(0, 100).limit(n).boxed().toList();
        /*for (int num: intList) {
            System.out.print(num + " ");
        }*/
        System.out.println();
        fizzBuzz(n, intList);
        System.out.println();
        fizzBuzzVer2(n, intList);
    }

    public static void fizzBuzz(int n, List<Integer> list) {
        List<Object> resList = new ArrayList<>();
        Time.start();
        for (int i = 0; i < n; i++) {
            if ((list.get(i) % 3 == 0) && (list.get(i) % 5 == 0)) {
                resList.add(Quiz.FIZZBUZZ);
                continue;
            }
            if (list.get(i) % 3 == 0) {
                resList.add(Quiz.FIZZ);
                continue;
            }
            if (list.get(i) % 5 == 0) {
                resList.add(Quiz.BUZZ);
                continue;
            }
            resList.add(list.get(i));
        }
        Time.finish();
//        System.out.println(Arrays.toString(resList.toArray()));
        System.out.println("End of first method");
    }

    public static void fizzBuzzVer2(int n, List<Integer> list) {
        List<Object> resList = new ArrayList<>();
        Time.start();
        for (int i = 0; i < n; i++) {
            if (list.get(i) % 3 == 0) {
                if (list.get(i) % 5 == 0) {
                    resList.add(Quiz.FIZZBUZZ);
                } else {
                    resList.add(Quiz.FIZZ);
                }
            } else if (list.get(i) % 5 == 0) {
                resList.add(Quiz.BUZZ);
            } else {
                resList.add(list.get(i));
            }
        }
        Time.finish();
//        System.out.println(Arrays.toString(resList.toArray()));
        System.out.println("End of second method");

    }
}
