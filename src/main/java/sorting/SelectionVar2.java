package sorting;

import help.Features;

public class SelectionVar2 extends Sorting{
    // вариант сортировки выбором с обменом элементов каждый раз после нахождения

    SelectionVar2(int[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Selection sorting var2";
    }
    public void sort() {
        for (int i = 0; i < getResultArray().length; i++) {
            for (int j = i + 1; j < getResultArray().length; j++) {
                if (getResultArray()[j] < getResultArray()[i]) {
                    Features.toSwap(getResultArray(), j, i);
                }
            }
        }
    }
}
