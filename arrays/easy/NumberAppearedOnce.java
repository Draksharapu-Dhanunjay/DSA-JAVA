package com.dhanunjay.arrays.easy;

import java.util.HashMap;
import java.util.Scanner;

public class NumberAppearedOnce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getSingleElementI(arr, n));
        System.out.println(getSingleElementII(arr));
        System.out.println(getSingleElementIII(arr));
    }
    /*
        Brute Force Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static int getSingleElementI(int[] arr, int n){
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(arr[j] == arr[i]){
                    count++;
                }
            }
            if(count != 2){
                return arr[i];
            }
        }
        return -1;
    }
    /*
        Better Approach
        Time Complexity: O(N + N)
        Space Complexity: O(n/2)
     */
    public static int getSingleElementII(int[] arr){
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i : arr){
            int value = hash.getOrDefault(i, 0);
            hash.put(i, value + 1);
        }
        for(Integer i : hash.keySet()){
            if(hash.get(i) != 2){
                return i;
            }
        }
        return  -1;
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static int getSingleElementIII(int[] arr){
        int value = 0;
        for(int i : arr){
            value ^= i;
        }
        return value;
    }
}
