package com.dhanunjay.patterns;

import java.util.Scanner;

public class BinaryNumberTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows :");
        int rows = sc.nextInt();
        int value = 1;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(value + " ");
                if (value == 1){
                    value--;
                }else {
                    value++;
                }
            }
            System.out.println();
        }
    }
}
