package com.dhanunjay.patterns;

import java.util.Scanner;

public class IncreasingNumberTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows :");
        int rows = sc.nextInt();
        int count = 1;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }
}
