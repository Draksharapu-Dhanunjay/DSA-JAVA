package com.dhanunjay.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MoveZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
//        moveI(arr, n);
        moveII(arr, n);
    }
    /*
        Brute Force Approach
        Time Complexity: O(N + N) -> O(2N)
        Spcae Complexity: O(N)
     */
    public static void moveI(int[] arr, int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(i > 0){
                list.add(i);
            }
        }
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        for(int i = list.size(); i < n; i++){
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }
    /*
       Optimal Approach
       Time Complexity: O(N)
       Spcae Complexity: O(1)
    */
    public static void moveII(int[] arr, int n){
         int i = -1;
         for(int j = 0; i < n; j++){
             if(arr[j] == 0){
                 i = j;
                 break;
             }
         }
         if(i != -1){
             for(int j = i + 1; j < n; j++){
                 if(arr[i] == 0){
                     arr[i] = arr[j];
                     arr[j] = 0;
                 }
                 if(arr[j] > 0 && arr[i] != 0){
                     i++;
                     arr[i] = arr[j];
                     arr[j] = 0;
                 }
             }
         }
        System.out.println(Arrays.toString(arr));
    }
}
