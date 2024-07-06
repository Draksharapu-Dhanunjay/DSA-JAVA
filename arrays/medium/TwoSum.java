package com.dhanunjay.arrays.medium;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target Sum :");
        int k = sc.nextInt();
        sumI(arr, n, k);
        sumII(arr, n , k);
        sumIII(arr, n, k);
    }
    /*
        Brute Force Approach
        Time Complexity: O(N * N)
        Space Complexity: O(1)
     */
    public static void sumI(int[] arr, int n, int k){
        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                if(i != j && arr[i] + arr[j] == k){
//                    System.out.println("[" + i + "," +j +"]");
//                    return;
//                }
//            }
            for(int j = i + 1; j < n; j++){
                if(arr[i] + arr[j] == k){
                    System.out.println("[" + i + "," +j +"]");
                    return;
                }
            }
        }
        System.out.println("[-1, -1]");
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(N)
     */
    public static void sumII(int[] arr, int n, int k){
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < n; i++){
            int diff = k - arr[i];
            if(hash.containsKey(diff)){
                System.out.println("[" + hash.get(diff) + "," + i  + "]");
                return;
            }else{
                hash.put(arr[i], i);
            }
        }
        System.out.println("[-1,-1]");
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static void sumIII(int[] arr, int n,  int k){
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i < n){
            if(arr[i] + arr[j] == k){
                System.out.println("Yes");
                return;
            }else if(arr[i] + arr[j] > k){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("No");
    }
}
