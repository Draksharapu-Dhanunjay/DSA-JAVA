package com.dhanunjay.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
    /*
        Time Complexity: O(N^2)
        Space Complexity: O(1)
     */
    public static void sort(int[] arr, int n){
        for(int i = 0; i < n - 1; i++){
            int j = i + 1;
            while (j > 0 && arr[j] < arr[j - 1]){
                swap(arr, j, j - 1);
                j--;
            }
        }
    }
    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
