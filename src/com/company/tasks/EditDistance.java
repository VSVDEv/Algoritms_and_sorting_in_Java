package com.company.tasks;

import java.util.Scanner;

/**
 *
 *Задача на программирование: расстояние редактирования
 * Вычислите расстояние редактирования двух данных непустых строк длины не более 10^2, содержащих строчные
 * буквы латинского алфавита.
 * Sample Input 1:
 * ab
 * ab
 * Sample Output 1:
 * 0
 * Sample Input 2:
 * short
 * ports
 * Sample Output 2:
 * 3
 *
 */
public class EditDistance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        int[][] dimension = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i < dimension.length; i++) {
            for (int j = 0; j < dimension[0].length; j++) {
                if (i == 0) {
                    dimension[i][j] = j;
                }
                else if (j == 0) {
                    dimension[i][j] = i;
                }
                else {
                    int c = first.charAt(i - 1) == second.charAt(j - 1)? 0 : 1;
                    dimension[i][j] = Math.min(dimension[i - 1][j - 1] + c,
                            Math.min(dimension[i - 1][j] + 1, dimension[i][j - 1] + 1));
                }
            }
        }
        System.out.println(dimension[first.length()][second.length()]);
    }
}