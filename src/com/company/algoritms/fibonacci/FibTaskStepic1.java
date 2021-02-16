package com.company.algoritms.fibonacci;

import java.util.Scanner;

/**
 *Задача на программирование: небольшое число Фибоначчи
 *
 *
 * Дано целое число 1 <= n <= 40, необходимо вычислить nn-е число Фибоначчи
 *
 *input 3
 * out 2
 *
 *
 */
public class FibTaskStepic1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;

        do {
            n = in.nextInt();
        } while (n < 1 || n > 40);

        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        System.out.print(arr[n]);
    }
}