package com.company.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *continuous backpack
 *Задача на программирование: непрерывный рюкзак
 * Первая строка содержит количество предметов 1 <= n <= 10^3
 *   и вместимость рюкзака 0 <= W <= 2 * 10^6
 *   Каждая из следующих nn строк задаёт стоимость 0 <= c_i <= 2 * 10^6предмета (n, W, c_i, wi
 *  — целые числа). Выведите максимальную стоимость частей предметов (от
 *  каждого предмета можно отделить любую часть, стоимость и объём при этом
 *  пропорционально уменьшатся), помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
 * Sample Input:
 * 3 50
 * 60 20
 * 100 50
 * 120 30
 * Sample Output:
 * 180.000
 *
 *
 */
public class ContinBackpack {
    public static void insertionSort(double[][] array) {
        for (int j = 0; j < array.length; j++) {
            int i = j - 1;
            while (i >= 0 && array[i][2] > array[i + 1][2]) {
                double temp = array[i][0];
                double temp1 = array[i][1];
                double temp2 = array[i][2];
                array[i][0] = array[i + 1][0];
                array[i][1] = array[i + 1][1];
                array[i][2] = array[i + 1][2];
                array[i + 1][0] = temp;
                array[i + 1][1] = temp1;
                array[i + 1][2] = temp2;
                i--;
            }
        }
    }

    public static double knapsack(double[][] array, double backpackCapacity) {
        double sum = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (backpackCapacity > array[i][1]) {
                sum += array[i][0];
                backpackCapacity -= array[i][1];
            } else {
                sum += backpackCapacity / array[i][1] * array[i][0];
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int thingsCount = sc.nextInt();
        double backpackCapacity = sc.nextDouble();
        double[][] data = new double[thingsCount][3]; //здесь получаемые из ввода данные

        for (int i = 0; i < thingsCount; i++) {
            for (int j = 0; j < 2; j++) {
                data[i][j] = sc.nextDouble();
            }
            data[i][2] = data[i][0] / data[i][1]; //здесь отношения с[i]/w[i]
        }

        insertionSort(data);

        double sum = knapsack(data, backpackCapacity);

        System.out.printf("%.3f", sum);
    }
}
/*
Etalon
 */
class Main {
    private static class Item implements Comparable<Item>{
        int cost;
        int volume;
        double average;

        public Item(int cost, int volume) {
            this.cost = cost;
            this.volume = volume;
            this.average = (double) cost / volume;
        }

        @Override
        public int compareTo(Item o) {
            return Double.compare(o.average, this.average);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Item> items = new ArrayList<Item>();

        int n = sc.nextInt();
        int W = sc.nextInt();
        for (int i = 0; i < n; i++){
            int cost = sc.nextInt();
            int volume = sc.nextInt();
            items.add(new Item(cost, volume));
        }
        sc.close();
        Collections.sort(items);
        double sum = 0;
        for (int i = 0; i < items.size(); i++){
            if (W <= 0)
                break;
            Item currentItem = items.get(i);
            if (currentItem.volume <= W){
                sum += currentItem.cost;
                W -= currentItem.volume;
            } else {
                sum += W * currentItem.average;
                break;
            }
        }
        System.out.println(String.format("%.3f", sum).replaceAll(",", "."));
    }
}
