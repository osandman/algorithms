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

    int indMin;

    @Override
    public void sort() {
        for (int i = 0; i < getResultArray().length; i++) {
            indMin = i;
            for (int j = i + 1; j < getResultArray().length; j++) {
                if (getResultArray()[j] < getResultArray()[indMin]) {
                    indMin = j;
                }
            }
            //меняем элементы, если найден минимальный элемент за индексом i в правой части массива
            //if (indMin > i) { //с проверкой работает дольше на 100000 элементах
            Features.toSwap(getResultArray(), indMin, i);
            //}
        }
    }
}
