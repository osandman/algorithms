package sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {
    static int count = 20;
    static int minValue = -10;
    static int maxValue = 10;
    static Random random = new Random();
    static int[] unsortedArray = random.ints(minValue, maxValue).limit(count).toArray();
    //unsortedArray = new int[]{-5, 4, -43, 2, 1};

    int[] getSortedArray() {
        int[] sortedArray = unsortedArray.clone();
        //получаем отсортированный массив встроенным методом java
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    private static List<Sorting> getSorting() {
        List<Sorting> sortingList = new ArrayList<>();
        //добавить метод сортировки ниже
        sortingList.add(new Bubble(unsortedArray));
        sortingList.add(new Selection(unsortedArray));
        sortingList.add(new SelectionVar2(unsortedArray));
        return sortingList;
    }

    @ParameterizedTest
    @MethodSource({"getSorting"})
    void sortingTest(Sorting sorting) {
        sorting.printResultArray();
        sorting.sort();
        assertArrayEquals(getSortedArray(), sorting.getResultArray());
        sorting.printResultArray();
    }
}