package com.company.tasks;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *Задача на программирование: наибольшая последовательнократная подпоследовательность
 * Дано целое число 1 <= n <= 10^3
 *   и массив A[1...n]A[1…n] натуральных чисел, не превосходящих 2 * 10^9
 *   Выведите максимальное 1 <= k <= n, для которого найдётся подпоследовательность
 *   1 <= i_1 < i_2 <... i_k <= n длины k, в которой каждый элемент делится на предыдущий
 *   (формально: для  всех 1 <= j < k, A[i_j] | A[i_j+1]).
 *
 * Sample Input:
 * 4
 * 3 6 7 12
 * Sample Output:
 * 3
 *
 */
public class LongMultipleSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int[] distance = new int[n];
        distance[0] = 1;
        for (int i = 1; i < array.length; i++) {
            distance[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] != 0 && array[i] % array[j] == 0 && distance[j] + 1 > distance[i])
                    distance[i] = distance[j] + 1;
            }
        }
        Arrays.sort(distance);
        int result = distance[distance.length - 1];
        System.out.println(result);
    }
}