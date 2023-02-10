package searching;

public class BinSearch {
    private static int index;

    public static int binRecursiveSearch(int[] numsArray, int num) {
        if (numsArray.length == 0) {
            return -1;
        }
        int left = 0;
        int right = numsArray.length - 1;
        return recursive(numsArray, left, right, num);
    }

    private static int recursive(int[] nums, int left, int right, int num) {
        index = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (nums[index] < num) {
            left = index + 1;
            return recursive(nums, left, right, num);
        } else if (nums[index] > num) {
            right = index - 1;
            return recursive(nums, left, right, num);
        } else {
            return index;
        }
    }

    public static int binCycleSearch(int[] numsArray, int num) {
        int left = 0;
        int right = numsArray.length - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            if (numsArray[index] > num) {
                right = index - 1;
            } else if (numsArray[index] < num) {
                left = index + 1;
            } else {
                return index;
            }
        }
        return -1;
    }
}
