package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO перевести на возвращение массива, не листа
public class Quick extends Sorting {
    Quick(int[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Quick sorting";
    }

    @Override
    public void sort() {
        List<Integer> sortedList = recursiveQuickSort(getInitList());
        setResultList(sortedList);
    }

    @Override
    public void printResultArray() {
        System.out.printf("Массив %s, отсортирован %b\n", this, isCorrectSort());
        System.out.println(getResultList());
        System.out.println("------------------------------------------------");
    }

    @Override
    boolean isCorrectSort() {
        return getResultList().equals(getInitList().stream().sorted().toList());
    }

    private List<Integer> recursiveQuickSort(List<Integer> array) {
        if (array.size() < 2) {
            return array;
        } else {
            int pivot = array.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> middle = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();
            for (int element : array) {
                if (element < pivot) {
                    less.add(element);
                } else if (element > pivot) {
                    greater.add(element);
                } else {
                    middle.add(pivot);
                }
            }
            List<Integer> all = new ArrayList<>(recursiveQuickSort(less));
            all.addAll(middle);
            all.addAll(recursiveQuickSort(greater));
            return all;
        }
    }
}
