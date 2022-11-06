package various.choco;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input N");
        int N = scanner.nextInt();
        System.out.println("Input M");
        int M = scanner.nextInt();
        System.out.println("Input K");
        int K = scanner.nextInt();
        System.out.println(ChocoDivide.chocoDivVer1(N, M, K));
        System.out.println(ChocoDivide.chocoDivVer2(N, M, K));
    }
}
