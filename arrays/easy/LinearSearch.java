package com.dhanunjay.arrays.easy;

import java.util.Scanner;
/*
    Time Complexity: O(N)
    Space Complexity: O(1)
 */

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Target :" );
        int target = sc.nextInt();
        int index = -1;
        for(int i = 0; i < n; i++){
            if(arr[i] == target){
                index = i;
                break;
            }
        }
        if(index >= 0){
            System.out.println("Element exist at index :" + index);
        }else {
            System.out.println("Element Doesn't Exist!!!");
        }
    }
}
