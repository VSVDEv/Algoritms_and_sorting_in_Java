package com.company.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * various terms
 * Задача на программирование: различные слагаемые
 * По данному числу 1 <= n <= 10^9
 *   найдите максимальное число k, для которого nn можно представить
 *   как сумму kk различных натуральных слагаемых. Выведите в первой строке число k, во второй — k слагаемых.
 * Sample Input 1:
 * 4
 * Sample Output 1:
 * 2
 * 1 3
 * Sample Input 2:
 * 6
 * Sample Output 2:
 * 3
 * 1 2 3
 *
 *
 */
public class VariousTerms {

    public static void main(String[] args) {
        int n;
        try(Scanner scaner = new Scanner(System.in)){
            n = scaner.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        int k = 1;
        while( n != 0 ) {
            if((n - k*2) > 0) {
                list.add(k);
                n = n - k;
                k++;
            } else {
                if((n - k) == 0)
                {
                    list.add(k);
                    n = n - k;
                }
                else k++;
            }
        }
        System.out.println(list.size());
        for(Integer temp : list) {
            System.out.print(temp +" ");
        }
    }
}

/*
Other variant
 */
class Main1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;

        StringBuilder sb = new StringBuilder();

        while ( n > 2 * i ) {
            n -= i;
            sb.append(i++ + " ");
        }

        sb.append(n);
        System.out.println(i);
        System.out.println(sb.toString());
    }
}