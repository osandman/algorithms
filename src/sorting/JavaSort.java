package sorting;

import java.util.Arrays;

//внутренняя сортировка java из класса Arrays
public class JavaSort extends Sorting {
    JavaSort(int[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Java built-in sorting";
    }

    @Override
    public void sort() {
        //resultArray = Arrays.stream(initArray).toArray();
        Arrays.sort(resultArray);
    }

}
