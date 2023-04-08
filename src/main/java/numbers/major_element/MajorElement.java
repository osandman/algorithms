package numbers.major_element;

import java.util.HashMap;
import java.util.Map;

/**
 * Дан массив целых чисел,
 * найти в вывести самое часто повторяющееся число
 * <p>
 * Constrains:
 * n = ints.length
 * 1 <= n <= 5 * 104
 * -109 <= ints[i] <= 109
 */
public class MajorElement {
    public static void main(String[] args) {
        System.out.println(getMajorElement2(new int[]{-1, 1, 3, 4, 4, 2, -1, 3, 4, 3, -1, 2, 2, 0, 0}));
    }

    private static int getMajorElement(int[] ints) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int majEl = 0;
        for (int el : ints) {
            if (!map.containsKey(el)) {
                map.put(el, 1);
            } else {
                map.put(el, map.get(el) + 1);
            }
            if (maxCount < map.get(el)) {
                maxCount++;
                majEl = el;
            }
        }
        return majEl;
//        int count = map.values().stream().max((a, b) -> a - b).get();
//        return map.entrySet().stream().filter(entry -> entry.getValue() == count).map(Map.Entry::getKey).findFirst().get();
    }

    private static int getMajorElement2(int[] ints) {
        int middle = 109;
        int[] counts = new int[middle * 2];
        int maxCount = 0;
        int majEl = 0;
        for (int anInt : ints) {
            counts[middle + anInt] += 1;
            if (maxCount < counts[middle + anInt]) {
                maxCount++;
                majEl = middle + anInt;
            }
        }
        majEl = majEl - middle;
        return majEl;
    }
}
