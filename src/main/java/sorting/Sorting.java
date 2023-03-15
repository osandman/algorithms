package sorting;

import java.util.Arrays;

public abstract class Sorting<T extends Comparable<T>> {
    private final T[] initArray;
    private T[] resultArray;

    Sorting(T[] initArray) {
        this.initArray = initArray;
        resultArray = initArray.clone(); // createNewArrayInstance(arraySize);
//        System.arraycopy(initArray, 0, resultArray, 0, initArray.length); //faster than clone
//        setInitList();
    }

    public void setResultArray(T[] resultArray) {
        this.resultArray = resultArray;
    }

    abstract public void sort();


    public T[] getInitArray() {
        return initArray;
    }


    public T[] getResultArray() {
        return resultArray;
    }

    //возварщает отсортированный массив внутренней соритровкой java
    public T[] getSortedArray() {
        T[] sortedArray = initArray.clone();// createNewArrayInstance(arraySize);
//        System.arraycopy(initArray, 0, sortedArray, 0, initArray.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public void swap(T[] array, int indX, int indY) {
        T temp = array[indX];
        array[indX] = array[indY];
        array[indY] = temp;
    }

    boolean isCorrectSort() {
        return Arrays.equals(getSortedArray(), resultArray);
    }

    public void printResultArray() {
        System.out.printf("Массив %s, отсортирован %b\n", this, isCorrectSort());
        System.out.println(Arrays.toString(resultArray));
        System.out.println("------------------------------------------------");
    }
}
