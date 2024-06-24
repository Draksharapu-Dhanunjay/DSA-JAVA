package com.dhanunjay.arrays.easy;

import java.util.Arrays;
import java.util.Scanner;

public class LeftRotateByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter number of places :");
        int k = sc.nextInt();
//        rotateI(arr, n, k);
        rotateII(arr, n, k);
    }
    /*
        BruteForce Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static void rotateI(int[] arr, int n, int k){
        k = k % n;
        int[] temp = new int[k];
        System.arraycopy(arr, 0, temp, 0, k);
        for(int i = k; i < n ; i++){
            arr[i - k] = arr[i];
        }
        for(int i = 0; i < temp.length; i++){
            arr[n - k + i] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }
    /*
        Optimal  Approach
        Time Complexity: O(N + N)
        Space Complexity: O(1)
     */
    public static void rotateII(int[] arr, int n, int k){
        k = k % n;
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
