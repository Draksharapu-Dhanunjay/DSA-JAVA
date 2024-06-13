package com.dhanunjay.basicmath;

import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :");
        int num = sc.nextInt();
        System.out.println("Number of Digits :" + digits(num));
        System.out.println("Number of Digits :" + (int) (Math.log10(num) + 1));
    }
    public static int digits(int num){
        int count = 0;
        while (num > 0){
            count++;
            num /= 10;
        }
        return count;
    }
}
