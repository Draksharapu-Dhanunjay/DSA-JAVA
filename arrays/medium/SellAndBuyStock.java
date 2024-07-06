package com.dhanunjay.arrays.medium;

import java.util.Scanner;

public class SellAndBuyStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        buyI(arr);
        buyII(arr);
    }
    /*
        Brute Force Approach
        Time Complexity: O(N*N)
        Space Complexity: O(1)
     */
    public static void buyI(int[] arr){
        int max = 0, n = arr.length;
        for(int i = 0; i < n; i++){
            int value = 0;
            for(int j = i + 1; j < n; j++){
                value = arr[j] - arr[i];
                max = Math.max(value, max);
            }
        }
        System.out.println(max);
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */

    public static void buyII(int[] arr){
        int max = 0, min = Integer.MAX_VALUE;
        for(int i: arr){
            min = Math.min(min, i);
            max = Math.max(max, i - min);
        }
        System.out.println(max);
    }
}
