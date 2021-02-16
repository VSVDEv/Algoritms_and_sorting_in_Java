package com.company.sorting.bublesort;

/**
 *
 *
 *
 * O(n2)
 * after first search max value in end array
 *
 *  int [] mas={32,42,-12,3213,-5,7};
 *
 *
 *  [32][42][-12][3213][-5][7]
 *  32?42=>   32< 42
 *  42>-12 => [32][-12][42]
 *  42>3213  =>  3213>42 [32][-12][42][3213]
 *  3213>-5 => [32][-12][42][-5][3213]
 *  3213>7 => [32][-12][42][-5][7][3213]
 *  second iteration
 *  32>-12 => [-12][32]......
 *
 */
public class BubleSort {
public static void bubleSort(int[] arr){
    for (int i = arr.length-1; i >0 ; i--) {
        for (int j = 0; j <i ; j++) {
            if(arr[j]>arr[j+1]){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }

}
    public static void bubleSortReverse(int[] arr){
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                if(arr[j]<arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
}
static void print(int[] arr){
    for (Integer i:arr
    ) {
        System.out.print(i+", ");
    }
}
    public static void main(String[] args) {
        int [] mas={32,42,-12,3213,-5,7};

      print(mas);
bubleSort(mas);
        System.out.println("*************************************");
        System.out.println("after sort");
print(mas);
        System.out.println("*************************************");
        System.out.println("after reverseSort");
        bubleSortReverse(mas);
        print(mas);
    }
}
