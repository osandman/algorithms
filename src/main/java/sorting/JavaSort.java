package sorting;

import java.util.Arrays;

//внутренняя сортировка java из класса Arrays
public class JavaSort<T extends Comparable<T>> extends Sorting<T> {
    JavaSort(T[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Java built-in sorting";
    }

    @Override
    public void sort() {
        //resultArray = Arrays.stream(initArray).toArray();
        Arrays.sort(getResultArray());
    }

}
