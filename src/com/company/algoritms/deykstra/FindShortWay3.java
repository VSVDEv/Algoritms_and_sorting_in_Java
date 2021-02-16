package com.company.algoritms.deykstra;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/** * Sample Input:
 *something wrong!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
public class FindShortWay3 {

    public static void main(String[] args) {

        int startPoint = 0;
        int endPoint = 0;
        int mapSize = 0;
        int[][] path = new int[][]{};
        int[][] weight = new int[][]{};
        boolean fistRead = true;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(" ");
            if (fistRead) {
                mapSize = Integer.parseInt(split[0]);
                path = new int[mapSize][mapSize];
                weight = new int[mapSize][mapSize];
                fistRead = false;
                continue;
            }
            if (!scanner.hasNextLine()) {
                startPoint = Integer.parseInt(split[0]) - 1;
                endPoint = Integer.parseInt(split[1]) - 1;
            }

            if(split.length == 3) {
                int indexX = Integer.parseInt(split[0]) - 1;
                int indexY = Integer.parseInt(split[1]) - 1;
                int value = Integer.parseInt(split[2]);

                path[indexX][indexY] = 1;
                weight[indexX][indexY] = value;
            }

        }


        int[] d = new int[mapSize];
        Set<Integer> coveredVertex = new HashSet<>();
        d[startPoint] = 0;
        for (int i = 1; i < d.length; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        while (coveredVertex.size() != d.length) {
            int w = findMinValue(d, coveredVertex);
            int minValueIndex = findMinIndex(d, coveredVertex);
            if(w == Integer.MAX_VALUE) {
                break;
            }
            for (int j = 0; j < path.length; j++) {
                if (path[minValueIndex][j] == 1) {
                    if (d[j] > w + weight[minValueIndex][j] && !coveredVertex.contains(d[j])) {
                        d[j] = w + weight[minValueIndex][j];
                    }
                }
            }
            coveredVertex.add(minValueIndex);
        }

        if(d[endPoint] == Integer.MAX_VALUE || d[endPoint] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(d[endPoint]);
        }
    }

    private static int findMinIndex(int[] d, Set<Integer> coveredIndex) {
        int minIndex = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < d.length; i++) {
            if (d[i] < minValue && !coveredIndex.contains(i)) {
                minValue = d[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int findMinValue(int[] d, Set<Integer> coveredIndex) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < d.length; i++) {
            if (d[i] < minValue && !coveredIndex.contains(i)) {
                minValue = d[i];
            }
        }
        return minValue;
    }
}