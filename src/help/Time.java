package help;


public class Time {
    static long delta, prevDelta;
    static long start;
    static long finish;

    public static void start() {
        start = System.currentTimeMillis();
    }

    //подставить выбранный метод
    public static long finish(String prompt, long... compareTime) {
        finish = System.currentTimeMillis();
        delta = finish - start;
        if (compareTime.length != 0 && compareTime[0] != 0) {
            System.out.printf("Время выполнения %s: %d мс, дольше в %d раз встроенной сортировки\n",
                    prompt, delta, Math.round((double) delta / compareTime[0]));
        } else System.out.printf("Время выполнения %s: %d мс\n", prompt, delta);
        return delta;
    }
}

