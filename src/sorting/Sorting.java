package sorting;


import java.util.Arrays;

public abstract class Sorting {
    int[] initArray;
    int[] resultArray;

    Sorting(int[] initArr) {
        initArray = initArr;
        resultArray = new int[initArray.length];
        System.arraycopy(initArray, 0, resultArray,0, initArray.length); //faster than clone
    }

    abstract public void sort();

    public int[] getResultArray() {
        return resultArray;
    }

    //метод для тестирования
    public void printIsSortedOk() {
        Arrays.sort(initArray);
        boolean isCorrectSort = Arrays.equals(getResultArray(), initArray);
        System.out.println(this + " отсортирован верно: ------------------" + isCorrectSort);
    }

    public void printResultArray() {
        System.out.println("Печатаем массив после сортировки: " + this);
        System.out.println(Arrays.toString(resultArray));
        System.out.println("------------------------------------------------");
    }
}
