package com.company.tasks;

import java.util.Scanner;

/**
 *largest common divisor
 *
 * наибольший общий делитель
 *
 * Задача на программирование: наибольший общий делитель
 *
 *   найдите их наибольший общий делитель.
 * Sample Input 1:
 * 18 35
 * Sample Output 1:
 * 1
 */
public class LargCommDivisor {

    public static long nod(long a, long b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a > b)
            return nod(a % b, b);
        if (b > a)
            return nod (a, b % a);
        if (a == b)
            return a;

        return -1;
    }

    public static long count(long a, long b) {
        return (a == 0 ? b
                : b == 0 ? a
                : a >= b ? count(a % b, b)
                : count(a, b % a));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long firstNumber = scanner.nextLong();
        long secondNumber = scanner.nextLong();

        System.out.println(nod(firstNumber, secondNumber));
        System.out.println(count(firstNumber, secondNumber));
    }
}