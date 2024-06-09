package com.dhanunjay.patterns;

import java.util.Scanner;

public class AlphaHillPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows :");
        int rows = sc.nextInt();
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < rows - i - 1; j++){
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++){
                System.out.print((char) ('A' + j));
            }
            for (int j = i; j > 0; j--){
                System.out.print((char) ('A' + j));
            }
            System.out.println();
        }
    }
}
