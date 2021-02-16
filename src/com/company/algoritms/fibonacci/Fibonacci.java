package com.company.algoritms.fibonacci;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Числа Фибоначчи
 *  Это числовой ряд, который выглядит следующим образом:
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 *
 * A0 = 0
 *
 * A1 = 1
 *
 * An+1 = An + An-1
 *
 * Необходимо реализовать функцию:
 *
 * на вход функция получает целое число n;
 *
 * необходимо вывести в консоль значение числа Фибоначчи под номером n;
 *
 * не рекомендуется использовать рекурсию.
 *
 * Sample Input 1:
 *
 * 6
 * Sample Output 1:
 *
 * 8
 *
 *
 *
 */
public class Fibonacci {


    void printFibonacci(long n){

        if (n == 1) System.out.print(1);
        else {
            long a = 0;
            long b = 1;
            long k = 2;
            long buf = 0;
            while (k <= n){
                buf = a + b;
                a = b;
                b = buf;
                k++;
            }
            System.out.print(buf);
        }
    }


    void printFibon(long n){
        long x = 0, y = 1;
        for (long i = 0; i < n; ++i) {
            long t = y;
            y = x + y;
            x = t;
        }
        System.out.println(x);
    }

    void printFib(long n){
        System.out.print(getFib(n));
    }

    long getFib(long n) {
        return Stream.generate(new Fibonnacher()).skip(n).findFirst().get();
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.printFib(1);
        System.out.println("");
        System.out.println("Second");
        f.printFibonacci(1);
        System.out.println("");
        System.out.println("Third");
        f.printFibon(1);

    }

}

 class Fibonnacher implements Supplier<Long> {

    private Long a;
    private Long b;

    public Long get() {
        if (a == null) {
            a = 0L;
            return a;
        }
        if (b == null) {
            b = 1L;
            return b;
        }
        long result = a + b;
        a = b;
        b = result;
        return result;
    }

}