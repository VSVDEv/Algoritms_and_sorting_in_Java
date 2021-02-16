package com.company.tasks;

import java.util.Scanner;

/**
 *
 *Задача на программирование: рюкзак
 * ?Первая строка входа содержит целые числа 1 <= W  <= 10^4  и
 * 1  <= n  <= 300 — вместимость рюкзака и число золотых слитков.
 * Следующая строка содержит nn целых чисел 0  <= w_1, ...., w_n  <= 10^5,
 * задающих веса слитков. Найдите максимальный вес золота, который можно унести в рюкзаке.
 * Sample Input:
 *          10 3
 *          1 4 8
 * Sample Output:
 * 9
 *
 */
public class Backpack {
    private void run() {
        Scanner input = new Scanner(System.in);
        int W = input.nextInt();
        int n = input.nextInt();
        int[] w = new int[n];
        int i, j;
        for (i = 0; i < n; i++) {
            w[i] = input.nextInt();
        }
        int[][] D = new int[n + 1][W + 1];
        for (i = 0; i < n + 1; i++) {
            D[i][0] = 0;
        }
        for (j = 0; j < W + 1; j++) {
            D[0][j] = 0;
        }
        for (i = 1; i < n + 1; i++) {
            for (j = 1; j < W + 1; j++) {
                D[i][j] = D[i - 1][j];
                if (w[i - 1] <= j) {
                    D[i][j] = Integer.max(D[i][j], D[i - 1][j - w[i - 1]] + w[i - 1]);
                }
            }
        }
        System.out.println(D[n][W]);
        input.close();
    }

    public static void main(String[] args) {
        new Backpack().run();
    }
}
/*
10 3
1 4 8
 */
 class Main5 {

    int[][] map;

    public int counting(int thing, int weight) {
        if (thing == 0 || weight == 0) {return 0;}
        if (map[thing][weight] != 0) {return map[thing][weight];}
        if (weight >= map[thing][0]) {
            int fst = map[thing][0] + counting(thing - 1, weight - map[thing][0]);
            int snd = counting(thing - 1, weight);
            int res = Math.max(fst, snd);
            map[thing][weight] = res;
            return res;
        }
        return counting(thing - 1, weight);
    }


    public void run() {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int n = sc.nextInt();
        map = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            map[i][0] = sc.nextInt();
        }
        System.out.println(counting(n, W));
    }

    public static void main(String[] args) {
        new Main5().run();
    }
}