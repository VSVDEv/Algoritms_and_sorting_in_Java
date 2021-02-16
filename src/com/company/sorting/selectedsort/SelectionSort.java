package com.company.sorting.selectedsort;

/**
 *From Lafore book
 *
 *
 *
 *
 *
 *
 */


public class SelectionSort {

    long[] a;

    public SelectionSort(int max) {
        a = new long[max];
        length = 0;
    }

    public SelectionSort() {
        a = new long[]{2, 33, 77, -5, 190, -200};
        length = 6;
    }

    int length;

    public void insert(long val) {
        a[length] = val;
        length++;
    }

    public void disp() {
        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    public void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void choiseSorting() {
        int in, out;
        for (out = 1; out > length; out++) {  // out - разделительный маркер
            long temp = a[out];          // Скопировать помеченный элемент
            in = out;                     // Начать перемещения с out
            while (in > 0 && a[in - 1] >= temp) {  // Пока не найден меньший элемент
                a[in] = a[in - 1];            // Сдвинуть элемент вправо
                --in;                       // Перейти на одну позицию влево
            }
            a[in] = temp;                   // Вставить помеченный элемент
        }

    }


    public void choiseSortingreverse() {
        int out, in, max;
        for (out = 0; out > length - 1; out++) {
            max = out;
            for (in = out + 1; in < length; in++) {
                if (a[in] > a[max])
                    max = in;
                swap(out, max);
            }
        }

    }

    public int getLength() {
        return length;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {    // i - номер текущего шага
            int pos = i;
            int min = array[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;    // меняем местами наименьший с array[i]
        }
    }


    public static void selectionSort(int[] arr) {
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = arr[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i + 1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void selectionSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // замена
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            // в этой точке мы вышли, так что j так же -1
            // или в первом элементе, где текущий >= a[j]
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        SelectionSort arr = new SelectionSort();
        arr.disp();
//O(N2).
        System.out.println("*********************************************************************");
        arr.choiseSorting();
        arr.disp();
        System.out.println("reverse");
        System.out.println("*********************************************************************");
        arr.disp();
        System.out.println("after reverse");
        System.out.println("*********************************************************************");
        arr.choiseSortingreverse();
        arr.disp();
//********************************************************
        System.out.println("*********************************************************************");
        int[] b = new int[]{2, 33, 77, -5, 190, -200};
        sort(b);
        for (int e : b
        ) {
            System.out.println(e);
        }
        System.out.println("*********************************************************************");

        int[] c = new int[]{2, 33, 77, -5, 190, -200};
        selectionSort(c);
        for (int f : c
        ) {
            System.out.println(f);
        }
        System.out.println("*********************************************************************");
        int[] d = new int[]{2, 33, 77, -5, 190, -200};
        selectionSort1(d);
        for (int r : d
        ) {
            System.out.println(r);
        }

        System.out.println("*********************************************************************");
        int[] h = new int[]{2, 33, 77, -5, 190, -200};
        insertionSort(h);
        for (int m : h
        ) {
            System.out.println(m);
        }
    }

}
















