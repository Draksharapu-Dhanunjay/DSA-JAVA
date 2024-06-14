package com.dhanunjay.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
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
        Space Complexity: O(N)
     */
    public static void sort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int start = low, end = mid + 1;
        while (start <= mid && end <= high){
            if(arr[start] <= arr[end]){
                list.add(arr[start]);
                start++;
            }else {
                list.add(arr[end]);
                end++;
            }
        }
        while (start <= mid){
            list.add(arr[start]);
            start++;
        }
        while (end <= high){
            list.add(arr[end]);
            end++;
        }
        for(int i = low; i <= high; i++){
            arr[i] = list.get(i - low);
        }
    }
}
