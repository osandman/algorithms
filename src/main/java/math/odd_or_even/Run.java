package math.odd_or_even;

public class Run {
    public static void main(String[] args) {
        System.out.println(oddOrNot(12));
    }

    static boolean oddOrNot(int num) {
        return (num & 1) != 0;
    }
}
