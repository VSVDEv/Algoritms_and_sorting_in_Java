package com.company.sorting.bublesort;

/**
 *
 * From Lafore book
 *
 *
 */
public class BublSort {

    long[] a ;
    public BublSort(int max){
        a=new long[max];
        length=0;
    }
    public BublSort(){
        a= new long[]{2, 33, 77, -5, 190, -200};
        length=6;
    }
    int length ;
    public void insert(long val){
        a[length]=val;
        length++;
    }
    public void disp(){
        for (int i = 0; i <length ; i++) {
            System.out.print(a[i]+", ");
        }
    }
    public void swap(int one, int two){
        long temp=a[one];
        a[one]=a[two];
        a[two]=temp;
    }
    public void bubleSorting(){
        int out,in;
        for (out=length-1;out>=1;out--)
            for (in=0;in<out;in++)
                if(a[in]>a[in+1])
                    swap(in,in+1);
    }

    public void swapreverse(int one, int two){
        long temp=a[one];
        a[one]=a[two];
        a[two]=temp;
    }
    public void bubleSortingreverse(){
        int out,in;
        for (out=length-1;out>=1;out--)
            for (in=0;in<out;in++)
                if(a[in]<a[in+1])
                    swapreverse(in,in+1);
    }

    public int getLength() {
        return length;
    }
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int aj = array[j];
                    int ai = array[i];
                    array[j] = ai;
                    array[i] = aj;
                }
            }
        }
        return array;
    }
    public static void bubbleSort(int[] arr){
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами

             */
                if( arr[j] > arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        BublSort arr =new BublSort();
        System.out.println("array before sort");
        arr.disp();
//O(N2).
        System.out.println("*********************-------------");
        arr.bubleSorting();
        System.out.println("after sort");
        arr.disp();
        System.out.println("*********************-------------");

        System.out.println("after reverse");
        arr.bubleSortingreverse();
        arr.disp();
//********************************************************

    }
}