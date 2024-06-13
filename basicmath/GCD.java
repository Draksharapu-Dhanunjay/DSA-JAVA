package com.dhanunjay.basicmath;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number1 :");
        int num1 = sc.nextInt();
        System.out.print("Enter a number2 :");
        int num2 = sc.nextInt();
        gcdI(num1, num2);
        gcdII(num1, num2);
    }
    /*
        Brute Force Approach
        Time Complexity: O(Min(n1, n2))
        Space Complexity: O(1)
     */
    public static void gcdI(int num1, int num2){
        int gcd =  1, min = Math.min(num1, num2);
        for(int i = 2; i <= min; i++){
            if(num1 % i == 0 && num2 % i == 0){
                gcd = i;
            }
        }
        System.out.println("GCD :" + gcd);
    }
    /*
        Optimal Approach
        Time Complexity: O(min(N1, N2))
        Space Complexity: O(1)
     */
    public static void gcdII(int num1, int num2){
        while (num1 > 0 && num2 > 0){
            if(num1 > num2){
                num1 = num1 % num2;
            }else {
                num2 = num2 % num1;
            }
        }
        System.out.println("GCD :" + Math.max(num1, num2));
    }
}
