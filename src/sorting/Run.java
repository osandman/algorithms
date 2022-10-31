package sorting;

import help.*;

import java.util.Arrays;
import java.util.Random;

public class Run {
    public static void main(String[] args) {
        int count = 100000;
        int minValue = 10000;
        int maxValue = 10000;
        Random random = new Random();
        int[] initialArray = new int[count];
        /*for (int i = 0; i < count; i++) {
            initialArray[i] = (random.nextBoolean()) ? random.nextInt(maxValue) : -random.nextInt(minValue);
        }*/
        initialArray = random.ints(-minValue, maxValue).limit(count).toArray();

        Selection sel = new Selection();
        Bubbles bub = new Bubbles();
        JavaSort jS = new JavaSort();
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(initialArray));
        System.out.println("Начало выполнения сортировок ...");
// сорт java внутренняя
        Time.start();
        jS.javaSort(initialArray);
        Time.finish(jS.toString());
        //System.out.println(Arrays.toString(sel.getResultArray()));
// сорт выбором вариант 1
        Time.start();
        sel.selectionSortVar1(initialArray);
        Time.finish(sel + ".Var1");
        //System.out.println(Arrays.toString(sel.getResultArray()));
// сорт выбором вариант 2
        Time.start();
        sel.selectionSortVar2(initialArray);
        Time.finish(sel + ".Var2");
        //System.out.println(Arrays.toString(sel.getResultArray()));
// сорт пузырьком
        Time.start();
        bub.bubbleSort(initialArray);
        Time.finish(bub.toString());
        //System.out.println(Arrays.toString(bub.getResultArray()));
        System.out.println("Отсортированные массивы равны = " + Arrays.equals(bub.getResultArray(), sel.getResultArray()));
        //Merge merge = new Merge();

    }
}
