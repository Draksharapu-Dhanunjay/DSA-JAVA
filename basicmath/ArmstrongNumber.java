package com.dhanunjay.basicmath;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :");
        int num = sc.nextInt();
        if (checkArmstrong(num)) {
            System.out.println(num + " is Armstrong");
        }else{
            System.out.println(num + " not Armstrong");
        }
    }
    public static boolean checkArmstrong(int num){
        int digits = (int)(Math.log10(num) + 1);
        double dup = num, value = 0;
        while (num > 0){
            value += Math.pow(num % 10, digits);
            num /= 10;
        }
        return dup == value;
    }
}
