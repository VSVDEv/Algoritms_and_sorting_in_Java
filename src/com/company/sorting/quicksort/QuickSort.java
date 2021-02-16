package com.company.sorting.quicksort;

/**
 * middle O(n log(n)).
 * O(n2)
 * int[] h= new int[]{2, 33, 77, -5, 190, -200};
 *quickSort(h,0,h.length-1);
 *quickSort(h,0,5);
 *{2, 33, 77, -5, 190, -200};=>{-200, 33, 77, -5, 190, 2}
 * =>{-200, -5, 77, 33, 190, 2} =>{-200, -5, 2, 33, 190, 77}
 */
public class QuickSort {
    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }






    public static void main(String[] args) {
        System.out.println("*********************************************************************");
        int[] h= new int[]{2, 33, 77, -5, 190, -200};
        quickSort(h,0,h.length-1);
        for (int m:h
        ) {
            System.out.println(m);
        }
    }
}