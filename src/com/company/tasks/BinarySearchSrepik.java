package com.company.tasks;

import java.util.Scanner;

/**
 *Задача на программирование: двоичный поиск
 * В первой строке даны целое число 1 <=n <= 10^5
 * 5
 *   и массив A[1 n]A[1…n] из nn различных натуральных чисел, не превышающих 10^9
 *  , в порядке возрастания, во второй — целое число 1 <=k <= 10^5
 *   и k натуральных чисел b_1,  b_kb
 *  , не превышающих 10^9
 *  . Для каждого ii от 1 до kk необходимо вывести индекс 1 \le j \le n1?j?n, для которого A[j]=b_iA[j]=b

 *  , или -1  если такого j нет.
 *
 * Sample Input:
 * 5 1 5 8 12 13
 * 5 8 1 23 1 11
 * Sample Output:
 * 3 1 -1 1 -1
 *
 *
 */
public class BinarySearchSrepik {


    public int check(int[] arr, int find){
        int mid;
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            mid = (start + end)/2;
            if (arr[mid] == find)
                return mid + 1;
            if (arr[mid] > find)
                end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        for (int i = 0; i < x; i++){
            System.out.print(check(arr, sc.nextInt()) + " ");
        }

//        System.out.println(check(array, find));
    }


    public static void main(String[] args) {
        new BinarySearchSrepik().run();
    }

}

