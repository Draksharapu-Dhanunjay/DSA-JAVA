package com.dhanunjay.arrays.easy;

import java.util.Scanner;

public class MissingNumberInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(missingNumberI(arr, n + 1));
        System.out.println(missingNumberII(arr, n + 1));
        System.out.println(missingNumberIII(arr));
    }
    /*
        Brute Force Approach
        Time Complexity: O(N * N)
        Space Complexity: O(1)
     */
    public static int missingNumberI(int[] arr, int n){
        for(int i = 1; i < n; i++){
            boolean flag = true;
            for (int k : arr) {
                if (k == i) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
    /*
        Optimal Approach
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public static int missingNumberII(int[] arr, int n){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        return (n * (n + 1))/ 2 - sum;
    }
    /*
        Optimal Approach
        Time Complexity: O(n)
        Space Complexity: O(1)
    */
    public static int missingNumberIII(int[] arr){
        int xor1 = 0, xor2 = 0;
        for(int i = 0; i < arr.length; i++){
            xor1 ^= (i + 1);
            xor2 ^= arr[i];
        }
        return xor1 ^ xor2 ^ ( arr.length + 1);
    }
}
