package com.company.algoritms.fibonacci;

import java.util.Scanner;

/**
 * Задача на программирование: последняя цифра большого числа Фибоначчи
 *
 *
 * Дано число 1 <= n <=10^7
 * , необходимо найти последнюю цифру n-го числа Фибоначчи.
 *
 * Как мы помним, числа Фибоначчи растут очень быстро, поэтому при их вычислении нужно быть аккуратным с переполнением.
 * В данной задаче, впрочем, этой проблемы можно избежать, поскольку нас интересует только последняя
 * цифра числа Фибоначчи: если a<= a,b <=9 — последние цифры чисел F_i and F i+1
 *  соответственно, то (a+b) mod10 — последняя цифра числа F_i+2
 *
 * input 841645
 * out 5
 *
 *
 */
public class FibTaskStepic2 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b1 = 0;
        int b2 = 1;

        for (int i = 1; i < a; i++) {
            int tmp = b1;
            b1 = b2;

            b2 = (b2 + tmp)%10;
        }

        System.out.println(b2);
    }
}