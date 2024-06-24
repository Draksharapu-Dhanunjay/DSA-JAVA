package com.dhanunjay.arrays.easy;

import java.util.Scanner;

public class LargestAndSmallestElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        largestAndSmallest(arr);
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static void largestAndSmallest(int[] arr){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i : arr){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }
        System.out.println("Min Element :" + min);
        System.out.println("Max Element :" + max);
    }
}
