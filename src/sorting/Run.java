package sorting;

import help.*;

import java.util.Arrays;
import java.util.Random;

public class Run {
    public static void main(String[] args) {
        int count = 100000;
        int minValue = -10000;
        int maxValue = 10000;
        Random random = new Random();
        int[] initialArray;
        initialArray = random.ints(minValue, maxValue).limit(count).toArray();

        //initialArray = new int[]{-5, 4, -43, 2, 1};


        Selection sel = new Selection(initialArray);
        Bubble bub = new Bubble(initialArray);
        JavaSort js = new JavaSort(initialArray);
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(initialArray));
        System.out.println("Начало выполнения сортировок ...");
// сорт java внутренняя
        Time.start();
        js.javaSort(initialArray);
        Time.finish(js.toString());
        js.printIsSortedOk();
//        js.printResultArray();
// сорт выбором вариант 1
        Time.start();
        sel.selectionSortVar1(initialArray);
        Time.finish(sel.toString());
        sel.printIsSortedOk();
//        sel.printResultArray();
// сорт выбором вариант 2
        Time.start();
        sel.selectionSortVar2(initialArray);
        Time.finish(sel.toString());
        sel.printIsSortedOk();
//        sel.printResultArray();
        // сорт пузырьком
        Time.start();
        bub.bubbleSort(initialArray);
        Time.finish(bub.toString());
        bub.printIsSortedOk();
//        bub.printResultArray();
        //Merge merge = new Merge();
    }
}
