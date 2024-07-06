package com.dhanunjay.arrays.medium;

import java.util.Scanner;

public class SubArrayMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSumI(arr,n));
        System.out.println(maxSumII(arr, n));
    }
    /*
        Brute Force Approach
        Time Complexity: O(N*N)
        Space Complexity: O(1)
     */
    public static int maxSumI(int[] arr, int n){
        int max = 0;
        for(int i = 0; i < n; i++){
            int sum = arr[i];
            for(int j = i + 1; j < n; j++){
                max = Math.max(max, sum);
                sum += arr[j];
            }
        }
        return max;
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static int maxSumII(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE,sum = 0, i = 0;
        while (i < n){
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0){
                sum = 0;
            }
            i++;
        }
        return maxSum;
    }
}
