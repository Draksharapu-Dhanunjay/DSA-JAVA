package com.dhanunjay.arrays.medium;

import java.util.Arrays;
import java.util.Scanner;

public class SetMatrixToZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows:");
        int m = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
//        setZeroI(arr, m, n);
//        setZeroII(arr, m, n);
        setZeroIII(arr, m, n);
    }
    /*
        BruteForce Approach
        Time Complexity: O((m * n )*(m + n)) + O(m * n)
        Space Complexity: O(1)
     */
    public static void setZeroI(int[][] arr, int m, int n){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    setColumn(arr, m, j);
                    setRow(arr, n, i);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == -1){
                    arr[i][j] = 0;
                }
            }
        }
        for(int[] i: arr){
            System.out.println(Arrays.toString(i));
        }
    }
    public static void setColumn(int[][] arr, int n, int j){
        for(int i = 0; i < n; i++){
            if(arr[i][j] !=0){
                arr[i][j] = -1;
            }
        }
    }
    public static void setRow(int[][] arr, int m, int i){
        for(int j = 0; j < m; j++){
            if(arr[i][j] !=0){
                arr[i][j] = -1;
            }
    }
    }
    /*
        Better Approach
        Time Complexity: O(m * n) + O(m * n)
        Space Complexity: O(m + n)
     */
    public static void setZeroII(int[][] arr, int m, int n){
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] == -1 || col[j] == -1){
                    arr[i][j] = 0;
                }
            }
        }
        for(int[] i: arr){
            System.out.println(Arrays.toString(i));
        }
    }
    /*
        Optimal Approach
        Time Complexity: O(N * M + N * M)
        Space Complexity: O(1)
     */
    public static void setZeroIII(int[][] matrix, int m, int n){
        int col0 = 1;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    if(col == 0){
                        col0 = 0;
                    }else{
                        matrix[0][col] = 0;
                    }
                }
            }
        }
        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int col = 1; col < n; col++){
                matrix[0][col] = 0;
            }
        }
        if(col0 == 0){
            for(int row = 0; row < m; row++){
                matrix[row][0] = 0;
            }
        }
        for(int[] i: matrix){
            System.out.println(Arrays.toString(i));
        }
    }
}
