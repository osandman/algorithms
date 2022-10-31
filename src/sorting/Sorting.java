package sorting;

import java.util.Arrays;

class Merge {
    //int [] mergeArray = sorting.intArray;
    public int[] iterativeMergeSort(int[] array) {
        int i = 0;
        int[] tempArray = new int[array.length];
        while (i < 0) {
        }
        return array;
    }
}

//внутренняя сортировка java
class JavaSort {
    @Override
    public String toString() {
        return "Java built-in sorting";
    }

    private int[] resultArray;

    public void javaSort(int[] initArray) {
        resultArray = initArray.clone();
        //resultArray = Arrays.stream(initArray).toArray();
        Arrays.sort(resultArray);
    }

    public int[] getResultArray() {
        return resultArray;
    }
}


class Selection {
    @Override
    public String toString() {
        return "Selection sorting";
    }

    private int[] resultArray;
    int min, indMin, temp;

    public void selectionSortVar1(int[] initArray) {
        resultArray = initArray.clone();
        for (int i = 0; i < resultArray.length; i++) {
            min = resultArray[i];
            indMin = i;
            for (int j = i + 1; j < resultArray.length; j++) {
                if (resultArray[j] < min) {
                    min = resultArray[j];
                    indMin = j;
                }
            }
            //меняем элементы, если найден минимальный элемент за индексом i в правой части массива
            if (indMin != i) {
                resultArray[indMin] = resultArray[i];
                resultArray[i] = min;
            }

        }
    }

    private void toSwap(int a, int b) {
        temp = resultArray[a];
        resultArray[a] = resultArray[b];
        resultArray[b] = temp;
    }

    // вариант сортировки выбором с обменом элементов каждый раз после нахождения
    public void selectionSortVar2(int[] initArray) {
        resultArray = initArray.clone();
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = i + 1; j < resultArray.length; j++) {
                if (resultArray[j] < resultArray[i]) {
                    toSwap(j, i);
                }
            }
        }
    }

    public int[] getResultArray() {
        return resultArray;
    }
}

class Bubbles {
    private int[] resultArray;

    @Override
    public String toString() {
        return "Bubble sorting";
    }

    public void bubbleSort(int[] initArray) {
        resultArray = initArray.clone();
        for (int i = 0; i < resultArray.length - 1; i++) {
            for (int j = 0; j < resultArray.length - i - 1; j++) {
                if (resultArray[j] > resultArray[j + 1]) {
                    toSwap(j, j + 1);
                }
            }
        }
    }

    public int[] getResultArray() {
        return resultArray;
    }

    private void toSwap(int indA, int indB) {
        int temp = resultArray[indA];
        resultArray[indA] = resultArray[indB];
        resultArray[indB] = temp;
    }

}
