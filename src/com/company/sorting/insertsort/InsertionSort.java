package com.company.sorting.insertsort;

/**
 * O(n2)
 *
 *insertionSort
 *  int[] arr = {-3, 4, 120, 33, -20};
 *  we get 4 and compare with previous element if 4 less than previous ve change place
 *  we get 120 and compare with 4 >120 false
 *  we get 33  and compare 120>33 true => we go to while and change places
 *  [3]=[120]
 *[2]=[33] and 33<4 false
 * get -20 and compare -20<120 true => set places compare -20<33 true set places.....
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;
            while (j >= 0 && curr < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
                arr[j + 1] = curr;
            }

        }
    }

    public static void print(int[] ar) {
        for(Integer a: ar){
            System.out.print(a+ ", ");
        }
    }
    public static void insSort(int[] arr) {
        for (int left = 0; left < arr.length; left++) {
            // Вытаскиваем значение элемента
            int value = arr[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            arr[i + 1] = value;
        }
    }
    public static void main(String[] args) {
        int[] arr = {-3, 4, 120, 33, -20};
print(arr);
        insertionSort(arr);
       // insSort(arr);
        System.out.println("after sort");
        print(arr);
    }


}
