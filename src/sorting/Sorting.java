package sorting;


import java.util.Arrays;

public abstract class Sorting {
    int[] initArray;
    int[] resultArray;

    Sorting(int[] initArray) {
        this.initArray = initArray;
    }

    abstract public void sort();

    public int[] getResultArray() {
        return resultArray;
    }

    public void printIsSortedOk() {
        int[] sortArray = initArray.clone();
        Arrays.sort(sortArray);
        boolean isCorrectSort = Arrays.equals(this.resultArray, sortArray);
        System.out.println(this + " отсортирован верно: ------------------" + isCorrectSort);
    }

    public void printResultArray() {
        System.out.println("Печатаем массив после сортировки: " + this);
        System.out.println(Arrays.toString(resultArray));
        System.out.println("------------------------------------------------");
    }
}
