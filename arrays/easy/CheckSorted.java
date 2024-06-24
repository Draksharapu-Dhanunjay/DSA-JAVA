package com.dhanunjay.arrays.easy;

import java.util.Scanner;

public class CheckSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        isSorted(arr, n);
    }
    public static void isSorted(int[] arr, int n){
        boolean sorted = true;
        for(int i = 0; i < n - 1; i++){
            if(arr[i] > arr[i + 1]){
                sorted = false;
                break;
            }
        }
        if(sorted){
            System.out.println("Array is sorted!");
        }else{
            System.out.println("Arrays is unsorted!");
        }
    }
}
