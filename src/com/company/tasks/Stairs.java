package com.company.tasks;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * Задача на программирование: лестница
 * Даны число 1 <= n <= 10^2 ступенек лестницы и целые числа -10^4 <= a_1, ...., a_n <= 10^4,
 * которыми помечены ступеньки. Найдите максимальную сумму, которую можно получить, идя по лестнице
 * снизу вверх (от нулевой до nn-й ступеньки), каждый раз поднимаясь на одну или две ступеньки.
 * Sample Input 1:
 * 2
 * 1 2
 * Sample Output 1:
 * 3
 * Sample Input 2:
 * 2
 * 2 -1
 * Sample Output 2:
 * 1
 * Sample Input 3:
 * 3
 * -1 2 1
 * Sample Output 3:
 * 3
 *
 */
public class Stairs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] stairs = new int[num];
        for (int i = 0; i < num; i++) {
            stairs[i] = scanner.nextInt();
        }
        int preprev = 0;
        int prev = stairs[0];
        int current = prev;
        for (int i = 1; i < num; i++) {
            current = Math.max(prev, preprev) + stairs[i];
            preprev = prev;
            prev = current;
        }
        System.out.println(current);
    }
}

class Main7 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = IntStream.generate(sc::nextInt).limit(n).toArray();
            if (n > 1) {
                arr[1] = Math.max(arr[1], arr[1] + arr[0]);
                IntStream.range(2, n).forEach(i -> arr[i] = Math.max(arr[i - 2], arr[i - 1]) + arr[i]);
            }
            System.out.println(arr[n - 1]);
        }
    }
}