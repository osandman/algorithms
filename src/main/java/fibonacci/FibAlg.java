package fibonacci;

import java.util.Scanner;
import java.util.ArrayList;

//todo разобраться с алгоритмом, см курс на stepik
public class FibAlg {
    int N;
    int i;
    Scanner MyScan = new Scanner (System.in);
    //long FibMas[];

    public void FirstAlg() {
        System.out.print(" введите N для поиска числа Фибоначчи: ");
        int N = MyScan.nextInt();
        long FibMas[] = new long[N+1];
        FibMas[0] = 0;
        FibMas[1] = 1;
        for (i = 2; i <= N; i++) {
            FibMas[i]=FibMas[i-1]+FibMas[i-2];
            System.out.println(i + "-е число Фибоначчи = "+ FibMas[i]);

        }
        System.out.println(N + "-е число Фибоначчи = "+ FibMas[N]);

    }

    public void PoslCh() {
        System.out.print(" введите N для поиска числа Фибоначчи: ");
        int N = MyScan.nextInt();
        int FibMasPCh[] = new int[N+1];
        FibMasPCh[0] = 0;
        FibMasPCh[1] = 1;
        for (int i = 2; i <= N; i++) {
            FibMasPCh[i]=FibMasPCh[i-1]+FibMasPCh[i-2];
//            if (FibMasPCh[i]>10) {
                FibMasPCh[i] = FibMasPCh[i] % 10;

//            }
            System.out.println("Последняя цифра " + i + "-го числа Фибоначчи = "+ FibMasPCh[i]);
        }
        System.out.print(FibMasPCh[N]);
    }

    public void OstOtDel() {
        ArrayList<Integer> PisMas = new ArrayList<Integer>();
        System.out.print("Введите N для поиска числа Фибоначчи: ");
        long N = MyScan.nextLong();
        System.out.print("Введите M - делитель: ");
        int M = MyScan.nextInt();
        //int PisMas[] = new int[50];
        int Ost;
        int CurrentOst;
        int PredOst;
        PisMas.add(0);
        PisMas.add(1);
        CurrentOst = PisMas.get(1);
        i = 2;
        while(true){
            PredOst = CurrentOst;
            CurrentOst = (PisMas.get(i - 1) + PisMas.get(i - 2)) % M;
            if (PredOst == 0 && CurrentOst == 1) {
                PisMas.remove(i-1);
                break;
            }
            PisMas.add(CurrentOst);
            System.out.println(i + " остаток от деления " + (PisMas.get(i - 1) + PisMas.get(i - 2)) + " на " + M + " = " + PisMas.get(i));
            i++;
        }
        Ost = PisMas.get((int)((N) % (i-1)));
        System.out.println(Ost);

    }

}

