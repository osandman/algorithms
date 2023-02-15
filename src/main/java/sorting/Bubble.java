package sorting;

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
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < getResultArray().length - 1; i++) {
                if (getResultArray()[i] > getResultArray()[i + 1]) {
                    swap(getResultArray(), i, i + 1);
                    isSorted = false;
                }
            }
        }
    }

}
