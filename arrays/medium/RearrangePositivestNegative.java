package com.dhanunjay.arrays.medium;

import java.util.Arrays;
import java.util.Scanner;

public class RearrangePositivestNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
//        rearrangeI(arr);
        rearrangeII(arr);
    }
    /*
        Brute Force Approach
        Time Complexity: O(2N)
        Space Complexity: O(N)
     */
    public static void rearrangeI(int[] arr){
        int[] pos = new int[arr.length / 2];
        int[] neg = new int[arr.length / 2];
        int i = 0, j = 0;
        for(int k : arr){
            if(k >= 0){
                pos[i] = k;
                i++;
            }else{
                neg[j] = k;
                j++;
            }
        }
        i = 0;
        j = 0;
        for(int k = 0; k < arr.length; k++){
            if(k % 2 == 0){
                arr[k] = pos[i];
                i++;
            }else{
                arr[k] = neg[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(N)
     */

    public static void rearrangeII(int[] arr){
        int[] ans = new int[arr.length];
        int pos = 0, neg = 1;
        for(int i : arr){
            if(i >= 0){
                ans[pos] = i;
                pos += 2;
            }else{
                ans[neg] = i;
                neg += 2;
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
