package sorting;

import help.Features;

import java.util.Arrays;

public abstract class AbstractSorting {
    int[] initArray;
    int[] resultArray;
    AbstractSorting(int[] initArray) {
        this.initArray = initArray;
    }
    abstract public void sort();
    public int[] getResultArray() {
        return resultArray;
    }
    public void printIsSortedOk() {
        int[] sortArray = initArray.clone();
        Arrays.sort(sortArray);
        boolean isReallySort = Arrays.equals(this.resultArray, sortArray);
        System.out.println(this + " отсортирован верно: ------------------" + isReallySort);
    }
    public void printResultArray() {
        System.out.println("Печатаем массив после сортировки: " + this);
        System.out.println(Arrays.toString(resultArray));
        System.out.println("------------------------------------------------");
    }
}
