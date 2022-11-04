package sorting;

import help.Features;

public class Bubble extends AbstractSorting {

    Bubble(int[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Bubble sorting";
    }

    @Override
    public void sort() {
        resultArray = initArray.clone();
        for (int i = 0; i < resultArray.length - 1; i++) {
            for (int j = 0; j < resultArray.length - i - 1; j++) {
                if (resultArray[j] > resultArray[j + 1]) {
                    Features.toSwap(resultArray, j, j + 1);
                }
            }
        }
    }

}
