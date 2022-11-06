package various.choco;

//определяем можно ли разделить шоколадку размерами NxM ломтиков одной линией на K ломтиков
public class ChocoDivide {
    static String chocoDivVer1(int N, int M, int K) {
        int divN = N;
        int divM = M;
        if (N == 0 || M == 0 || K == 0) {
            return "NO";
        }
        while (K <= M*N && (K >= divM || K >= divN)) {
            if (K == divM || K == divN) {
                return "YES";
            }
            divM = divM + M;
            divN = divN + N;
        }
        return "NO";
    }

    static String chocoDivVer2(int N, int M, int K) {
        if (N == 0 || M == 0 || K == 0) {
            return "NO";
        }
        return ((K % N == 0) && (K / N <= M) || (K % M == 0) && (K / M <= N)) ? "YES" : "NO";
    }
}
