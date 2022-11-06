package sorting;

import help.Features;

public class Selection extends Sorting {

    Selection(int[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Selection sorting";
    }

    int min, indMin;

    @Override
    public void sort() {
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
            if (indMin > i) {
                Features.toSwap(resultArray, indMin, i);
            }
        }
    }
}
