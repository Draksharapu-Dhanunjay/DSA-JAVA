package com.dhanunjay.patterns;

import java.util.Scanner;

public class RightAngledNumberPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows :");
        int rows = sc.nextInt();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j <= i; j++){
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }
}
