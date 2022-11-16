package help;

public class Features {
    public static void toSwap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static String getClassName(){
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        return ste.getClassName();
    }

}
