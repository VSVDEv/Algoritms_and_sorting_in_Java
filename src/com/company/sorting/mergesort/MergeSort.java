package com.company.sorting.mergesort;

/**
 *O(n logn)
 * we sort left half and right hals of array then we combine(unite) them
 *int[] h= new int[]{2, 33, 77, -5, 190, -200}; length=6
 * mergeSort(h,0,h.length-1);
 * mergeSort(h,0,5);
 * 0+5/2 = 2
 *mergeSort(array, left, mid);
 * mergeSort(array, 0, 2);
 * merge(array, left, mid, right);
 * merge(array, 0, 2, 5);
 * leftl=3
 * rightl=3 => create two arrays with leftl and righl
 * {2, 33, 77}; {-5, 190, -200};=>
 * {2, 33, 77}; {-200,-5, 190};=>
 * 2?-200
 * {-200,}=>
 * 2?-5=>
 * {-200, -5,}=> 2?190=>{-200, -5, 2,}=> 33?190=> {-200, -5, 2,33,}....
 *
 */
public class MergeSort {

    static void merge(int[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаем временные подмассивы
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;

        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }


    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    public static void main(String[] args) {
        System.out.println("*********************************************************************");
        int[] h= new int[]{2, 33, 77, -5, 190, -200};
        mergeSort(h,0,h.length-1);
        for (int m:h ) {
            System.out.println(m);
        }
    }
}

