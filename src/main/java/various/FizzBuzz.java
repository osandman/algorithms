package various;

import help.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// тестирование показывает что метод с вложенными if работает быстрее, чем
// последовательные if
// для исключениея Integer кэширования тестировал на типе Double
public class FizzBuzz {
    public enum Quiz {
        FIZZ, BUZZ, FIZZBUZZ
    }

    public static void main(String[] args) {

        int n = 10_000_000;
        int maxValue = 10000;
        Random rand = new Random();
        //заполняем ArrayList числами от 0 до 100, количество элементов = n
//        List<Integer> inputList = rand.ints(0, 100).limit(n).boxed().toList();
        List<Double> inputList = rand.doubles(0, maxValue)
                .limit(n).boxed().toList();
        /*for (int num: inputList) {
            System.out.print(num + " ");
        }*/
        System.out.println();
        fizzBuzz(n, inputList);
        System.out.println();
        inputList = rand.doubles(0, maxValue)
                .limit(n).boxed().toList();
        fizzBuzzVer2(n, inputList);
    }

    public static void fizzBuzz(int n, List<Double> list) {
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
        Time.finish("v1");
//        System.out.println(Arrays.toString(resList.toArray()));
        System.out.println("End of first method");
    }

    public static void fizzBuzzVer2(int n, List<Double> list) {
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
        Time.finish("v2");
//        System.out.println(Arrays.toString(resList.toArray()));
        System.out.println("End of second method");

    }
}
