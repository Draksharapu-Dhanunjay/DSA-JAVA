package com.dhanunjay.arrays.medium;

import java.util.Arrays;
import java.util.Scanner;

public class RotateImage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows:");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] ans = rotateI(matrix);
        for(int[] a: ans){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("********************************************");
        rotateII(matrix);
        for(int[] arr: matrix){
            System.out.println(Arrays.toString(arr));
        }
    }
    /*
        Brute Force Approach
        Time Complexity: O(N * N)
        Space Complexity: O(N * N)
     */
    public static int[][] rotateI(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for(int row = 0; row < n;row++){
            for(int col = 0; col < n; col++){
                ans[col][n - 1 - row] = matrix[row][col];
            }
        }
        return ans;
    }
    /*
        Optimal Approach
        Time Complexity: O(N * N) + O(N * N)
        Space Complexity: O(1)
     */
    public static void rotateII(int[][] matrix){
        int n = matrix.length;
        for(int row = 0; row < n; row++){
            for(int col = row; col < n; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        for (int[] arr : matrix) {
            reverse(0, n - 1, arr);
        }
    }
    public static void reverse(int start, int end, int[] arr){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
