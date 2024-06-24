package com.dhanunjay.arrays.easy;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestAndSecondSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        getElementsI(new int[] {1,7,4,2,7,5}, 6);
        getElementsII(arr, n);
        getElementsIII(arr, n);
    }
    /*
        Brute Force Approach
        Time Complexity: O(N(Log(N)) + N + N)
        Space Complexity: O(1)
     */
    public static void getElementsI(int[] arr, int n){
        Arrays.sort(arr);
        int min = arr[0], max = arr[n - 1];
        for(int i = 1; i < n; i++){
            if(arr[i] != min){
                System.out.println("Second Min : " + arr[i]);
                break;
            }
        }
        for(int i = n - 2; i > 0; i--){
            if(arr[i] != max){
                System.out.println("Second Max :" + arr[i]);
                break;
            }
        }
    }
    /*
        Better Approach
        Time Complexity: O(N) + O(N)
        Space Complexity: O(1)
     */
    public static void getElementsII(int[] arr, int n){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int sMin = Integer.MAX_VALUE, sMax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(arr[i] < min){
                sMin = min;
                min = arr[i];
            }
            if(arr[i] > min && arr[i] < sMin){
                sMin = arr[i];
            }
        }
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                sMax = max;
                max = arr[i];
            }
            if(arr[i] < max && arr[i] > sMax){
                sMax = arr[i];
            }
        }
        System.out.println("Min :" + min + " Second Min :" + sMin);
        System.out.println("Max :" + max + " Second Max :" + sMax);
    }

    /*
        Optimal Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static void getElementsIII(int[] arr, int n){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int sMin = Integer.MAX_VALUE, sMax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(arr[i] < min){
                sMin = min;
                min = arr[i];
            }
            if(arr[i] > min && arr[i] < sMin){
                sMin = arr[i];
            }
            if(arr[i] > max){
                sMax = max;
                max = arr[i];
            }
            if(arr[i] < max && arr[i] > sMax){
                sMax = arr[i];
            }
        }
        System.out.println("Min :" + min + " Second Min :" + sMin);
        System.out.println("Max :" + max + " Second Max :" + sMax);
    }
}
