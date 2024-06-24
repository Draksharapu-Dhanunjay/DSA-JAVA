package com.dhanunjay.arrays.easy;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArrayEqualsToK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k value :");
        int k = sc.nextInt();
        System.out.println(subArrayI(arr, n, k));
        System.out.println(subArrayII(arr, n , k));
        //only if all elements are positive
        boolean isPositive = true;
        for(int i : arr){
            if(i < 0){
                isPositive = false;
                break;
            }
        }
        if(isPositive){
            System.out.println(subArrayIII(arr, n, k));
        }

    }
    /*
        Brute Force Approach
        Time Complexity: O(N * N)
        Space Complexity: O(1)
     */
    public static int subArrayI(int[] arr, int n ,int k){
        int max = 0;
        for(int i = 0; i < n; i++){
            int sum = arr[i];
            for(int j = i + 1; j < n; j++){
                if(sum == k){
                    max = Math.max(j - i, max);
                    break;
                }
                sum += arr[j];
            }
        }
        return max;
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(N)
     */
    public static int subArrayII(int[] arr, int n, int k){
        HashMap<Integer, Integer> hash = new HashMap<>();
        int sum = 0, maxLen = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == k){
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if(hash.containsKey(rem)){
                maxLen = Math.max(maxLen, i - hash.get(rem) + 1);
            }else{
                hash.put(sum, i);
            }
        }
        return maxLen;
    }
    /*
        Optimal Approach -> Only Applicable if arr contains only positive numbers
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static int subArrayIII(int[] arr, int n, int k){
        int i = 0, j = 0, sum = 0, max = 0;
        while (j < n){
            if(sum == k){
                max = Math.max(max, j - i);
                sum += arr[j++];
            }else if(sum > k){
                sum -= arr[i];
                i++;
            }else{
                sum += arr[j];
                j++;
            }
        }
        if(sum == k){
            max = Math.max(max, j - i);
        }
        return max;
    }
}
