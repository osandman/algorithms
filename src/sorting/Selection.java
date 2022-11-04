package sorting;

import help.Features;

public class Selection extends AbstractSorting {
    String selVar = "!!!";

    Selection(int[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Selection sorting " + selVar;
    }

    int min, indMin;

    public void selectionSortVar1(int[] initArray) {
        selVar = "Var1";
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

    // вариант сортировки выбором с обменом элементов каждый раз после нахождения
    public void selectionSortVar2(int[] initArray) {
        selVar = "Var2";
        resultArray = initArray.clone();
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = i + 1; j < resultArray.length; j++) {
                if (resultArray[j] < resultArray[i]) {
                    Features.toSwap(resultArray, j, i);
                }
            }
        }
    }
}
