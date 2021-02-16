package com.company.tasks;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 *
 *Задача на программирование: калькулятор
 * У вас есть примитивный калькулятор, который умеет выполнять всего три операции с текущим числом x:
 * заменить x на 2x, 3x или x+1. По данному целому числу 1 <= n <= 10^5 определите минимальное число операций k,
 * необходимое, чтобы получить n из 1. Выведите kk и последовательность промежуточных чисел.
 * Sample Input 1:
 * 1
 * Sample Output 1:
 * 0
 * 1
 * Sample Input 2:
 * 5
 * Sample Output 2:
 * 3
 * 1 2 4 5
 * Sample Input 3:
 * 96234
 * Sample Output 3:
 * 14
 * 1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234
 *
 *
 */
public class Calculator {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int counting(int num) {
        if (num == 1) {
            map.put(1,0);
            return 0;
        }
        else if (num % 3 == 0) {
            map.put(num, num/3);
            return 1 + counting(num / 3);
        }
        else if (num % 2 == 0) {
            int div = counting(num/2);
            int sub = counting(num-1);
            map.put(num, div < sub ? num/2 : num -1);
            return 1 + Math.min(div, sub);
        } else {
            map.put(num, num -1);
            return 1 + counting(num - 1);
        }
    }

    public void run() {
        int n = new Scanner(System.in).nextInt();
        System.out.println(counting(n));
        StringBuilder ans = new StringBuilder();
        while (n >= 1) {
            ans.insert(0, n + " ");
            n = map.get(n);
        }
        System.out.println(ans);
    }

    public static void main(String args[]) {
        new Calculator().run();
    }
}

class Main8 {
    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] x = new int[n + 1];
        x[1] = 0;
        for (int i = 2; i <= n; i++) {
            int k1 = Integer.MAX_VALUE;
            int k2 = Integer.MAX_VALUE;
            int k3;
            if (i % 3 == 0) {
                k1 = x[i / 3];
            }
            if (i % 2 == 0) {
                k2 = x[i / 2];
            }
            k3 = x[i - 1];
            x[i] = Integer.min(Integer.min(k1, k2), k3) + 1;
        }
        int k = x[n];
        System.out.println(k);
        // восстанавливаем ответ
        int[] ans = new int[k + 1];
        while (n > 0) {
            ans[k] = n;
            k--;
            if (n % 3 == 0 && x[n / 3] == k) {
                n /= 3;
                continue;
            } else if (n % 2 == 0 && x[n / 2] == k) {
                n /= 2;
                continue;
            }
            n--;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        new Main8().run();
    }
}
