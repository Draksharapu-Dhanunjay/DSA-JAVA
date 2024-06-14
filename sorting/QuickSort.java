package com.dhanunjay.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
    /*
        Time Complexity: O(Nlog(N))
        Space Complexity: O(1)
     */
    public static void sort(int[] arr, int low, int high){
        if(low < high){
            int pIndex = partitionIndex(arr, low, high);
            sort(arr, low, pIndex - 1);
            sort(arr, pIndex + 1, high);
        }
    }
    public static int partitionIndex(int[] arr, int low, int high){
        int i = low + 1, j = high;
        while (i < j){
            while (arr[i] <= arr[low] && i <= high - 1){
                i++;
            }
            while (arr[j] > arr[low] && j >= low + 1){
                j++;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
        return i;
    }
}
