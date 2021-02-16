package com.company.algoritms.deykstra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/** * Sample Input:
         *
         * 4 8
         * 1 2 6
         * 1 3 2
         * 1 4 10
         * 2 4 4
         * 3 1 5
         * 3 2 3
         * 3 4 8
         * 4 2 1
         * 1 4
         * Sample Output:
         *
         * 9
         *
         */
public class FindShortWay2 {

    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        matrix = new int[n][n];
        int w = 0;
        int v1 = 0;
        int v2 = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], -1);
        }
        for (int i = 0; i < k; i++) {
            v1 = scan.nextInt();
            v2 = scan.nextInt();
            w = scan.nextInt();
            matrix[v1-1][v2-1] = w;
        }
        int start = scan.nextInt();
        int end = scan.nextInt();
        int[] res = dijkstra(n, start-1);
        if (res[end-1] == (int)Double.POSITIVE_INFINITY/2) {
            System.out.println(-1);
        } else {
            System.out.println(res[end-1]);
        }
    }

    public static int[] dijkstra(int n, int start) {
        int[] d = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            d[i] = (int)Double.POSITIVE_INFINITY/2;
            q.add(i);
        }
        d[start] = 0;
        while (!q.isEmpty()) {
            int v = 0;
            int min = (int)Double.POSITIVE_INFINITY/2+3;
            for (Integer i: q) {
                if (d[i]<min) {
                    min = d[i];
                    v = i;
                }
            }
            q.remove(v);
            for (int i = 0; i < n; i++) {
                if (matrix[v][i] != -1) {
                    if (d[i] > d[v] + matrix[v][i]) {
                        d[i] = d[v] + matrix[v][i];
                    }
                }
            }
        }
        return d;
    }
}
