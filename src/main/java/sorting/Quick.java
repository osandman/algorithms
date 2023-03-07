package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//TODO переделать на сортировку через массив
public class Quick<T extends Comparable<T>> extends Sorting<T> {
    public Quick(T[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Quick sorting";
    }

    @Override
    public void sort() {
        List<T> sortedList = recursiveQuickSort(Arrays.asList(getInitArray()));
        setResultArray((T[]) sortedList.toArray(new Comparable[0]));
    }

    private List<T> recursiveQuickSort(List<T> list) {
        if (list.size() < 2) {
            return list;
        } else {
            T pivot = list.get(0);
            List<T> less = new ArrayList<>();
            List<T> middle = new ArrayList<>();
            List<T> greater = new ArrayList<>();
            for (T element : list) {
                if (element.compareTo(pivot) < 0) {
                    less.add(element);
                } else if (element.compareTo(pivot) > 0) {
                    greater.add(element);
                } else {
                    middle.add(pivot);
                }
            }
            List<T> all = new ArrayList<>(recursiveQuickSort(less));
            all.addAll(middle);
            all.addAll(recursiveQuickSort(greater));
            return all;
        }
    }
}
