package com.company.sorting.selectedsort;


/**
 *
 *            [0]min ? =>min=> compare other if min [0]=-5; => [1]....
 * int[] arr = {-3, 19, -5, 110, 77};
 * we get [0] eg -3 as min
 * next elem less than min
 * -3>19 false go to next element
 * -3>-5 true save position min elem and value is min and compare with other element
 * if -5 less other we change links [0]=-5
 * next iteration we get [1]19 and compare to find min element
 * it will be -3 we get -3 and compare to other and it will min => we change
 * [1]=-3.......
 *
 *
 */
public class SelSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {    // i - current step
            int pos = i;
            int min = array[i];
            // loop selection min element
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;    // pos - index min element
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;    // change place min with array[i]
        }
    }
    static void print(int[] arr) {
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }}
        public static void main (String[]args){
            int[] arr = {-3, 19, -5, 110, 77};
            System.out.println("before sort");
            print(arr);
            System.out.println("***************************************");

            sort(arr);
            System.out.println("after sort");
            print(arr);

        }
    }
