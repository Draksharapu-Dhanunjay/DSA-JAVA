package com.dhanunjay.arrays.medium;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubArrayWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter K value :");
        int k = sc.nextInt();
        System.out.println(subArraySumI(arr, k));
        System.out.println(subArraySumII(arr, k));
    }
    /*
        BruteForce Approach
        Time Complexity: O(N * N)
        Space Complexity: O(1)
     */
    public static int subArraySumI(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(N)
     */
    public static int subArraySumII(int[] arr, int k){
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0, n = arr.length;
        mpp.put(0, 1);
        for (int j : arr) {
            preSum += j;
            int remove = preSum - k;
            cnt += mpp.getOrDefault(remove, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}
