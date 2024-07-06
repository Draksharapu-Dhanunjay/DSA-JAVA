package com.dhanunjay.arrays.medium;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows:");
        int m = sc.nextInt();
        System.out.print("Enter number of columns:");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
    /*
        Optimal Approach
        Time Complexity: O(M * N)
        Space Complexity: O(M * N)
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }
            top++;


            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;


            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }


            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
