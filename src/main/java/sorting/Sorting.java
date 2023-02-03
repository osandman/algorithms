package sorting;


import java.util.Arrays;
import java.util.List;

public abstract class Sorting {
    private final int[] initArray;
    private int[] resultArray;

    Sorting(int[] initArr) {
        initArray = initArr;
        resultArray = new int[initArray.length];
        System.arraycopy(initArray, 0, resultArray, 0, initArray.length); //faster than clone
    }

    abstract public void sort();

    public int[] getInitArray() {
        return initArray;
    }

    public int[] getResultArray() {
        return resultArray;
    }

    //возварщает отсортированный массив внутренней соритровкой java
    private int[] getSortedArray() {
        int[] sortedArray = initArray.clone();
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    private boolean isCorrectSort() {
        return Arrays.equals(getSortedArray(), resultArray);
    }

    public void printResultArray() {
        System.out.printf("Массив %s, отсортирован %b\n", this, isCorrectSort());
        System.out.println(Arrays.toString(resultArray));
        System.out.println("------------------------------------------------");
    }
}
