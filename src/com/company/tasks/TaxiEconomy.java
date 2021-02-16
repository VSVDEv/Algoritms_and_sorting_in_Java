package com.company.tasks;

/**
 *
 * После затянувшегося совещания директор фирмы решил заказать такси,чтобы развезти сотрудников по домам.
 * Он заказал N машин —ровно столько, сколь у него сотрудников.Однако когда они подъехали, оказалось, что
 * у каждого водителя такси свой тариф за 1 километр.
 * * Директор знает, какому сотруднику сколько километров от работы до дома (к сожалению, все сотрудники живут
 * в разных направлениях, поэтому нельзя отправить двух сотрудников на одной машине). Теперь директор хочет определить,
 * сколько придется заплатить за перевозку всех сотрудников. Естественно, директор хочет заплатить как можно меньшую сумму.
 *
 * Входные данные
 * В первой строке записаны N чисел через пробел, задающих расстояния в километрах от работы до домов сотрудников компании.
 * Во второй строке записаны N чисел — тарифы за проезд одного километра в такси.
 *
 * Выходные данные
 * Выведите одно целое число — наименьшую сумму, которую придется заплатить за доставку всех сотрудников.
 *
 * Director call taxis one for each employee. Taxi have different price and way for each employee different
 * we need to find minimum sum price
 *
 *
 */
public class TaxiEconomy {
    public static void main(String[] args) {
        String distance = "15 6 10 22 7 5 3 14 18 8 20 16 21 7 11";
        String price = "0.58 0.91 0.55 0.49 0.9 0.94 0.72 0.68 0.59 0.7 0.81 0.69 0.82 0.62 0.85";
        System.out.println(getSumTaxi(sortArray(stringToDouble(distance), 1), sortArray(stringToDouble(price), 0)));
    }

    public static double[] stringToDouble(String str) {
        String[] temp = str.split(" ");
        double[] num = new double[temp.length];
        for (int i = 0; i < temp.length; i++) {
            num[i] = Double.parseDouble(temp[i]);
        }
        return num;
    }

    public static double[] sortArray(double[] array, int index) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (index > 0) {
                    if (array[j] > array[j + 1]) {
                        double temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } else {
                    if (array[j] < array[j + 1]) {
                        double temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        return array;
    }

    public static double getSumTaxi(double[] distance, double[] price) {
        double sum = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i] * price[i];
        }
        return sum;
    }
}