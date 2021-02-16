package com.company.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * Задача на программирование: точки и отрезки
 * ?В первой строке задано два целых числа 1 <= n  <= n 50000  1  <=  m <=  50000
 * — количество отрезков и точек на прямой, соответственно. Следующие n строк содержат по два целых числа a_i
 * и b_i
 *   (a_i  <=  b_i) — координаты концов отрезков. Последняя строка содержит mm целых чисел — координаты точек.
 *   Все координаты не превышают 10^8
 *   по модулю. Точка считается принадлежащей отрезку, если она находится внутри него или на границе.
 *   Для каждой точки в порядке появления во вводе выведите, скольким отрезкам она принадлежит.
 * Sample Input:
 * 2 3
 * 0 5
 * 7 10
 * 1 6 11
 * Sample Output:
 * 1 0 0
 *
 */
public class DotsAndLinesStepic {

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i;
        int[][] segment = new int[n][2];
        for (i = 0; i < n; i++) {
            segment[i][0] = scanner.nextInt();
            segment[i][1] = scanner.nextInt();
        }
        int[] point = new int[m];
        for (i = 0; i < m; i++) {
            point[i] = scanner.nextInt();
        }
        int[] segmentCount = new int[m];
        Arrays.sort(segment, Comparator.comparingInt(a -> a[1]));
        for (i = 0; i < m; i++) {
            segmentCount[i] = binarySearchRight(segment, point[i]);
        }
        Arrays.sort(segment, Comparator.comparingInt(a -> a[0]));
        for (i = 0; i < m; i++) {
            segmentCount[i] -= binarySearchLeft(segment, point[i]);
            System.out.print(segmentCount[i] + " ");
        }
    }

    private int binarySearchRight(int[][] sortedSegment, int point) {
        int l = 0;
        int r = sortedSegment.length - 1;
        int m;
        while (l <= r) {
            m = (r + l) / 2;
            if (sortedSegment[m][1] >= point) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return sortedSegment.length - (r + 1);
    }

    private int binarySearchLeft(int[][] sortedSegment, int point) {
        int l = 0;
        int r = sortedSegment.length - 1;
        int m;
        while (l <= r) {
            m = (r + l) / 2;
            if (sortedSegment[m][0] > point) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return sortedSegment.length - (r + 1);
    }

    public static void main(String[] args) {
        new DotsAndLinesStepic().run();
    }
}