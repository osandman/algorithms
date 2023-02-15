package sorting;

import help.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run {
    public static void main(String[] args) {
        int count = 100000;
        int minValue = -100;
        int maxValue = 100;
        Random random = new Random();
        int[] initialArray;
        initialArray = random.ints(minValue, maxValue).limit(count).toArray();
//        initialArray = new int[]{-5, 4, -43, 2, 1};
        // сорт java внутренняя отдельно для сравнения
        Sorting javaSort = new JavaSort(initialArray);
        //создаем лист со всеми типами сортировок и добавляем в него их
        List<Sorting> sortingList = new ArrayList<>();
        // сорт пузырьком
        sortingList.add(new Bubble(initialArray));
        // сорт выбором
        sortingList.add(new Selection(initialArray));
        // сорт выбором var2
        sortingList.add(new SelectionVar2(initialArray));
        // быстрая сортировка
        sortingList.add(new Quick(initialArray));
/*
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(initialArray));
*/
        System.out.println("Начало выполнения сортировок ...");
        Time.start();
        javaSort.sort();
        long javaSortTime = Time.finish(javaSort.toString());

        for (Sorting sorting : sortingList) {
            Time.start();
            sorting.sort();
            Time.finish(sorting.toString(), javaSortTime);
//            sorting.printResultArray();
        }
    }
}