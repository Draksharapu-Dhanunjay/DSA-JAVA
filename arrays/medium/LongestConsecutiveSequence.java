package com.dhanunjay.arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        longestI(arr);
        longestII(arr);
        longestIII(arr);
    }
    /*
        BruteForce Approach
        Time Complexity: O(N * N)
        Space Complexity: O(1)
     */
    public static void longestI(int[] arr){
        int longest = 1;
        for(int i : arr){
            int curElement = i + 1, count = 1;
            while (linearSearch(curElement, arr)){
                curElement++;
                count++;
            }
            longest = Math.max(longest, count);
        }
        System.out.println(longest);
    }
    public static boolean linearSearch(int target, int[] arr){
        for(int i : arr){
            if(i == target){
                return true;
            }
        }
        return false;
    }
    /*
        Better Approach
        Time Complexity: O(Nlog(N) + N)
        Space Complexity: O(1)
     */
    public static void longestII(int[] arr){
        Arrays.sort(arr);
        int preElement = Integer.MIN_VALUE, longest = 1, count = 1;
        for(int i : arr){
            if(preElement + 1== i){
                count ++;
                preElement = i;
            }else if(preElement != i){
                preElement = i;
                count = 1;
            }
            longest = Math.max(longest, count);
        }
        System.out.println(longest);
    }
    /*
        Optimal Approach
        Time Complexity: O(N + N)
        Space Complexity: O(N)
     */
    public static void longestIII(int[] arr){
        HashSet<Integer> list = new HashSet<>();
        int longest = 1, count = 1;
        for(int i: arr){
            list.add(i);
        }
        for(int i: arr){
            if(!list.contains(i - 1)){
                int value = i + 1;
                while (list.contains(value)){
                    count++;
                    value++;
                }
                longest = Math.max(longest, count);
            }
        }
        System.out.println(longest);
    }
}
