package com.company.algoritms.binarysearch;

import java.util.Scanner;

public class StepikBinarSearchTask {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        for (int i = 0; i < k; i++) {
            int index = binarySearch(scan.nextInt(), arr);
            if (index == -1) {
                System.out.println(-1 + " ");
            } else {
                System.out.println(index + 1 + " ");
            }
        }
    }

    public static int binarySearch(int number, int[] arr) {
        int right = arr.length - 1;
        int left = 0;
        while (left <= right) {
            int m = (int) (right + left) / 2;
            if (number == arr[m]) {
                return m;              //возвращаем индекс
            } else if (number > arr[m]) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return -1;
    }
}


