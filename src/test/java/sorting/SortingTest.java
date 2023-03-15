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
    //    static int[] unsortedArray = random.ints(minValue, maxValue).limit(count).toArray();
//    static Integer[] unsortedArray = new Integer[]{-5, 4, -43, 2, 1};
    static String[] unsortedArray = new String[]{"as", "b", "asd", "342", "!op", "-|-", "1", "b"};
    //    static Integer[] sortedArray = new Integer[unsortedArray.length];
    static String[] sortedArray = new String[unsortedArray.length];

    static {
        sortArray();
    }

    public static void sortArray() {
        System.arraycopy(unsortedArray, 0, sortedArray, 0, unsortedArray.length);
        Arrays.sort(sortedArray);
    }

    /*    private static List<Sorting<Integer>> getSorting() {
            List<Sorting<Integer>> sortingList = new ArrayList<>();
            //добавить метод сортировки ниже
            sortingList.add(new Bubble<>(unsortedArray));
            sortingList.add(new Selection<>(unsortedArray));
            sortingList.add(new SelectionVar2<>(unsortedArray));
            return sortingList;
        }*/
    private static List<Sorting<String>> getSorting() {
        List<Sorting<String>> sortingList = new ArrayList<>();
        //добавить метод сортировки ниже
        sortingList.add(new Bubble<>(unsortedArray));
        sortingList.add(new Selection<>(unsortedArray));
        sortingList.add(new SelectionVar2<>(unsortedArray));
        sortingList.add(new Quick<>(unsortedArray));
        return sortingList;
    }

    @ParameterizedTest
    @MethodSource({"getSorting"})
    void sortingTest(Sorting<Integer> sorting) {
        sorting.printResultArray();
        sorting.sort();
        assertArrayEquals(sortedArray, sorting.getResultArray());
        sorting.printResultArray();
    }
}