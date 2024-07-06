package com.dhanunjay.arrays.medium;

import java.util.ArrayList;
import java.util.Scanner;

public class LeaderInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        leadersI(arr, n);
        leadersII(arr, n);
    }
    /*
        Brute Force Approach
        Time Complexity: O(N * N)
        Space Complexity: O(N)
     */
    public static void leadersI(int[] arr, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            boolean isLeader = true;
            for(int j = i + 1; j < n; j++){
                if(arr[j] > arr[i]){
                    isLeader = false;
                    break;
                }
            }
            if(isLeader){
                ans.add(arr[i]);
            }
        }
        System.out.println(ans);
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(N)
     */
    public static void leadersII(int[] arr, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = n - 1; i > 0; i--){
            if(arr[i] > max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        System.out.println(ans);
    }
}
