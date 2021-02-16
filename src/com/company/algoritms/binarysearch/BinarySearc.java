package com.company.algoritms.binarysearch;

/**
 *
 *BEFORE START ARRAY MUST BE SORTED!!!!!
 * log10 100 = 2.
 * log always means log2.
 * log8 == 3, because 23 == 8.
 * (log2 100 equals 7),
 *O(log п)
 *     WE find 9
 *     int mid = (low + high) / 2;
 *                             mid   mid(3) mid(2)
 * OUR ARRAY [1][2][3][4][5][6][7][8][9][10][11][12][13][14]
  *     low  [0][1][2][3][4][5][6][7][8][9][10][11][12][13]! length=14  (int high = list.length - 1;)
  * int guess = list[mid];//6
 *            while (low <= high) {  //0<=13 true
 *           if (guess == item) {  //   7 ==9 false
 *                 return mid;
 *             }
 *             if (guess > item) {  //7>9  false
 *                 high = mid - 1;
 *             } else {
 *                 low = mid + 1; // low=8  => next iteration
 *             }
 *             ------second iteration ---
 *                  while (low <= high) {  //8<=13 true
 *                  int mid = (low + high) / 2; // 8+13/2=10
 *                  int guess = list[mid];//10
 *  *           if (guess == item) {  //   11 ==9 false
 *  *                 return mid;
 *  *             }
 *  *             if (guess > item) {  //11>9  true
 *  *                 high = mid - 1;// high=9  => next iteration
 *  *             } else {
 *  *                 low = mid + 1;
 *  *             }
 *  -------------------------------------third iteration----------
 *                  while (low <= high) {  //8<=9 true
 *  *                  int mid = (low + high) / 2; // 8+9/2=8
 *  *                  int guess = list[mid];//8
 *  *  *           if (guess == item) {  //   9 ==9 true
 *  *  *                 return mid;  //mid =8==> end
 *  *  *             }
 *  *  *             if (guess > item) {
 *  *  *                 high = mid - 1;
 *  *  *             } else {
 *  *  *                 low = mid + 1;
 *  *  *             }
 *
 *
 *
 */
public class BinarySearc {

    // has to return boxed integer in order to comfort to interface defined in the book
    private static Integer binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] myList = {1, 3, 5, 7, 9};

        System.out.println(binarySearch(myList, 3)); // 1
        System.out.println(binarySearch(myList, -1)); // null
    }
}


