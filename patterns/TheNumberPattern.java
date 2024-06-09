package com.dhanunjay.patterns;

import java.util.Scanner;

public class TheNumberPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number :");
        int num = sc.nextInt();
        for (int i = 0; i < 2 * num - 1; i++){
            for (int j = 0; j < 2 * num - 1; j++){
                System.out.print(num - Math.min(Math.min(i, j), Math.min(2 * num  - 2 - i, 2 * num - 2 - j)));
            }
            System.out.println();
        }
    }
}
