package com.dhanunjay.arrays.medium;

import java.util.Scanner;

public class PrintSubArrayWithMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        maxSumI(arr, n);
        maxSumII(arr, n);
    }
    /*
        Brute Force Approach
        Time Complexity: O(N * N)
        Space Complexity: O(1)
     */
    public static void maxSumI(int[] arr, int n){
        int start = 0, end = 0, max = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += arr[j];
                if(sum > max){
                    max = sum;
                    end = j;
                    start = i;
                }
            }
        }
        System.out.println("Max :" + max);
        System.out.println("Length :" + (end - start + 1));
        for(int i = start; i <= end; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void maxSumII(int[] arr, int n){
        int i = 0, sum = 0, max = 0, start = 0, end = 0, preStart = 0;
        while (i < n){
            sum += arr[i];
            if(sum > max){
                max = sum;
                start = preStart;
                end = i;
            }
            i++;
            if(sum < 0){
                sum = 0;
                preStart = i;
            }
        }
        System.out.println("Max :" + max);
        System.out.println("Length :" + (end - start + 1));
        for(int j = start; j <= end; j++){
            System.out.print(arr[j] + " ");
        }
    }
}
