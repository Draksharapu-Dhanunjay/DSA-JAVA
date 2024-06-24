package com.dhanunjay.arrays.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicateSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
//        int m = removeDuplicatesI(arr, n);
        int m = removeDuplicatesII(arr, n);
        for(int i = 0; i < m; i++){
            System.out.print(arr[i] + " ");
        }
    }
    /*
        Brute Force Approach
        Time Complexity: O(N) + O(N)
        Space Complexity: O(N)
     */
    public static int removeDuplicatesI(int[] arr,int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return list.size();
    }
    public static int removeDuplicatesII(int[] arr, int n){
        int i = 0, j = 0;
        while (j < n){
            if(arr[i] != arr[j]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        return i + 1;
    }
}
