package com.company.algoritms.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * Another variant for task
 *
 *
 *
 */
public class StepikBinarySearchTask {


        long binarySearch(long[] arr, long goal) {
            int left = 0, right = arr.length - 1;
            int middle;

            while (left <= right) {
                middle = (left + right) / 2;
                if (arr[middle] == goal)
                    return middle + 1;
                if (arr[middle] < goal)
                    left = middle + 1;
                else
                    right = middle - 1;
            }
            return -1;
        }

        void run() throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tk;

            String line = br.readLine();
            tk = new StringTokenizer(line);
            long[] numbers = new long[Integer.parseInt(tk.nextToken())];
            int i = 0;
            while (tk.hasMoreTokens()) {
                numbers[i++] = Long.parseLong(tk.nextToken());
            }

            line = br.readLine();
            tk = new StringTokenizer(line);
            tk.nextToken();


            StringBuilder ans = new StringBuilder();
            while (tk.hasMoreTokens()) {
                ans.append(binarySearch(numbers, Long.parseLong(tk.nextToken()))).append(" ");
            }
            System.out.println(ans);

        }


        public static void main(String[] args) throws IOException {
            new StepikBinarySearchTask().run();
        }
    }

