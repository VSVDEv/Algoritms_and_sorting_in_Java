package com.company.algoritms.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *адача на программирование повышенной сложности: огромное число Фибоначчи по модулю
 *
 *
 * Даны целые числа 1 <= n <=10^18 and 2<=m<=10^5
 *
 * 5
 *  , необходимо найти остаток от деления nn-го числа Фибоначчи на m.
 *input 10 2
 * output 1
 *
 */
public class FibTaskStepic3 {

    public static void main(String[] args) {
        List<Long> pisano = new ArrayList<Long>();
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        scanner.close();
        pisano.add(0l);
        pisano.add(1l);
        int f1 = 0;
        int f2 = 1;
        for(int i = 2; i <= m * 6; i++){
            int fib = (int)((f1  + f2) % m);
            f1 = f2;
            f2 = fib;
            if (pisano.get(pisano.size() - 1) == 0 && fib == 1){
                pisano.remove(pisano.size() - 1);
                break;
            }
            pisano.add((long)fib);
        }
        System.out.println(pisano.get((int)(n % pisano.size())));
    }
}