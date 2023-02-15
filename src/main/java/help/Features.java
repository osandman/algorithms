package help;

public class Features {
    public static String getClassName() {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        return ste.getClassName();
    }

}
