package sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Sorting {
    private final int[] initArray;
    private final int[] resultArray;
    private List<Integer> initList;
    private List<Integer> resultList;

    Sorting(int[] initArray) {
        this.initArray = initArray;
        this.resultArray = new int[initArray.length];
        System.arraycopy(initArray, 0, resultArray, 0, initArray.length); //faster than clone
        setInitList();
    }
    abstract public void sort();

    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
    }

    public List<Integer> getInitList() {
        return initList;
    }

    public int[] getInitArray() {
        return initArray;
    }

    public List<Integer> getResultList() {
        return resultList;
    }
    public int[] getResultArray() {
        return resultArray;
    }

    //возварщает отсортированный массив внутренней соритровкой java
    public int[] getSortedArray() {
        int[] sortedArray = new int[initArray.length];
        System.arraycopy(initArray, 0, sortedArray, 0, initArray.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }
    public void swap(int[] array, int indX, int indY) {
        int temp = array[indX];
        array[indX] = array[indY];
        array[indY] = temp;
    }
    boolean isCorrectSort() {
        return Arrays.equals(getSortedArray(), resultArray);
    }

    private void setInitList() {
        initList = new ArrayList<>();
        for (int num : resultArray) {
            initList.add(num);
        }
    }
    public void printResultArray() {
        System.out.printf("Массив %s, отсортирован %b\n", this, isCorrectSort());
        System.out.println(Arrays.toString(resultArray));
        System.out.println("------------------------------------------------");
    }
}
