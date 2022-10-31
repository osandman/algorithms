package help;


public class Time {
    static long delta;
    static long start;
    static long finish;

    public static void start() {
        start = System.currentTimeMillis();
    }

    //подставить выбранный метод
    public static long finish(String prompt) {
        finish = System.currentTimeMillis();
        delta = finish - start;
        System.out.println("Время выполнения " + prompt + ": " + delta + "мс");
        return delta;
    }
    public static long finish() {
        finish = System.currentTimeMillis();
        delta = finish - start;
        System.out.println("Время выполнения: " + delta + "мс");
        return delta;
    }

}

