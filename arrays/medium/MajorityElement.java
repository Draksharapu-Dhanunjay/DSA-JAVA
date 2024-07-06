package com.dhanunjay.arrays.medium;

import java.util.Scanner;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(majorityI(arr, n));
        System.out.println(majorityII(arr, n));
        System.out.println(majorityIII(arr, n));
    }
    /*
        Brute Force Approach
        Time Complexity: O(N * N)
        Space Complexity: O(1)
     */
    public static int majorityI(int[] arr, int n){
        for(int i = 0; i  < n; i++){
            int count = 1;
            for(int j = 0; j < n; j++){
                if(i != j && arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > n / 2){
                return arr[i];
            }
        }
        return -1;
    }
    /*
        Better Approach
        Time Complexity: O(N + N)
        Space Complexity: O(N)
     */
    public static int majorityII(int[] arr, int n){
        HashMap<Integer, Integer> map = new HashMap<> ();
        for(int i : arr){
            int value = map.getOrDefault(i, 0);
            map.put(i, value + 1);
        }
        for(Integer i: map.keySet()){
            if(map.get(i) > n / 2){
                return i;
            }
        }
        return -1;
    }
    public static int majorityIII(int[] arr, int n){
        int ele = arr[0], count = 0;
        for(int i: arr){
            if(count == 0){
                ele = i;
            }
            if(ele == i){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for(int i : arr){
            if(ele == i){
                count++;
            }
        }
        if(count > n / 2){
            return ele;
        }
        return -1;
    }
}
