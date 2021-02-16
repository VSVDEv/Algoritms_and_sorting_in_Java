package com.company.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * cover line segments with dots
 *Задача на программирование: покрыть отрезки точками
 * По данным n отрезкам необходимо найти множество точек минимального размера,
 * для которого каждый из отрезков содержит хотя бы одну из точек.
 * В первой строке дано число 1 <= n<=100 отрезков.
 * Каждая из последующих nn строк содержит по два числа 0 <=l<= r<= 10^9
 *  , задающих начало и конец отрезка. Выведите оптимальное число m точек и сами m точек.
 *  Если таких множеств точек несколько, выведите любое из них.
 * Sample Input 1:
 * 3
 * 1 3
 * 2 5
 * 3 6
 * Sample Output 1:
 * 1
 * 3
 *
 */
public class CoverLineDots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int segmentsCount = scanner.nextInt();
        int[][] segments = new int[segmentsCount][2];
        for (int i = 0; i < segmentsCount; i++) {
            segments[i][0] = scanner.nextInt();
            segments[i][1] = scanner.nextInt();
        }
        Arrays.sort(segments, Comparator.comparingInt(a -> a[1]));

        int points = 0;
        int lastPoint = -1;
        StringBuilder pointsResult = new StringBuilder();
        for (int i = 0; i < segmentsCount; i++) {
            if (lastPoint < segments[i][0]) {
                lastPoint = segments[i][1];
                points++;
                pointsResult.append(lastPoint).append(" ");
            }
        }
        System.out.println(points);
        System.out.println(pointsResult);
    }
}