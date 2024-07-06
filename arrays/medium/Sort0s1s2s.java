package com.dhanunjay.arrays.medium;

import java.util.Arrays;
import java.util.Scanner;

public class Sort0s1s2s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(sortI(Arrays.copyOf(arr, n))));
        System.out.println(Arrays.toString(sortII(arr, n)));
        System.out.println(Arrays.toString(sortIII(arr, n)));
    }
    /*
        Brute Force Approach
        Time Complexity: O(log(N))
        Space Complexity: O(1)
     */
    public static int[] sortI(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
    /*
        Better Approach
        Time Complexity: O(N + N)
        Space Complexity: O(1)
     */
    public static int[] sortII(int[] arr, int n){
        int zeros = 0, ones = 0;
        for(int i : arr){
            if(i == 0){
                zeros++;
            }else if(i == 1){
                ones++;
            }
        }
        for(int i = 0; i < zeros; i++){
            arr[i] = 0;
        }
        for(int i = zeros; i < zeros + ones; i++){
            arr[i] = 1;
        }
        for(int i = zeros + ones; i < n; i++){
            arr[i] = 2;
        }
        return arr;
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static int[] sortIII(int[] arr, int n){
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high){
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            }else if(arr[mid] == 1){
                mid++;
            }else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        return arr;
    }
}
