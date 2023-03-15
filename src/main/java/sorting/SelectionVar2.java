package sorting;

public class SelectionVar2<T extends Comparable<T>> extends Sorting<T> {
    // вариант сортировки выбором с обменом элементов каждый раз после нахождения

    public SelectionVar2(T[] initArray) {
        super(initArray);
    }

    @Override
    public String toString() {
        return "Selection sorting var2";
    }

    public void sort() {
        for (int i = 0; i < getResultArray().length; i++) {
            for (int j = i + 1; j < getResultArray().length; j++) {
                if (getResultArray()[j].compareTo(getResultArray()[i]) < 0) {
                    swap(getResultArray(), j, i);
                }
            }
        }
    }
}
