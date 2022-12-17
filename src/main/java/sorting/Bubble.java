package sorting;

import help.Features;

public class Bubble extends Sorting {
    Bubble(int[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Bubble sorting";
    }

    @Override
    public void sort() {
        for (int i = 0; i < getResultArray().length - 1; i++) {
            for (int j = 0; j < getResultArray().length - i - 1; j++) {
                if (getResultArray()[j] > getResultArray()[j + 1]) {
                    Features.toSwap(getResultArray(), j, j + 1);
                }
            }
        }
    }

}
