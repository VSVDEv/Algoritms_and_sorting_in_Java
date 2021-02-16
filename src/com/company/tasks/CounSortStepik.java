package com.company.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 *
 *Задача на программирование: сортировка подсчётом
 * Первая строка содержит число 1 <= n <= 10^4
 *  , вторая — n натуральных чисел, не превышающих 10.
 *  Выведите упорядоченную по неубыванию последовательность этих чисел.
 * Sample Input:
 * 5
 * 2 3 9 2 9
 * Sample Output:
 * 2 2 3 9 9
 *
 *
 */
public class CounSortStepik {

    private void run() {

        int[] array;
        int[] result;
        int[] butches = new int[11];
        StringBuilder sb;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            final int qty = Integer.parseInt(br.readLine().trim());
            String[] numbers = br.readLine().split(" ");

            array = new int[qty];
            result = new int[qty];
            sb = new StringBuilder(qty);

            IntStream.rangeClosed(0, qty - 1).forEach(i -> array[i] = Integer.parseInt(numbers[i]));
            IntStream.rangeClosed(0, qty - 1).forEach(i -> butches[array[i]] = butches[array[i]] + 1);
            IntStream.rangeClosed(1, 10).forEach(i -> butches[i] = butches[i] + butches[i - 1]);

            for (int i = qty - 1; i >= 0; i--) {
                result[butches[array[i]] - 1] = array[i];
                butches[array[i]] = butches[array[i]] - 1;
            }

            IntStream.rangeClosed(0, qty - 1).forEach(i -> sb.append(result[i]).append(" "));
            System.out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CounSortStepik().run();
    }
}
