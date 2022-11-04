package help;


public class Time {
    static long delta, prevDelta;
    static long start;
    static long finish;

    public static void start() {
        start = System.currentTimeMillis();
        //todo доделать расчет разницы времени со встроенной сортировкой
        prevDelta = delta;
    }

    //подставить выбранный метод
    public static long finish(String prompt) {
        finish = System.currentTimeMillis();
        delta = finish - start;
        System.out.println("Время выполнения " + prompt + ": " + delta + "мс");
        return delta;
    }

}

