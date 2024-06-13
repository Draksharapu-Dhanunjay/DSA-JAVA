package com.dhanunjay.basicmath;

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :");
        int num = sc.nextInt();
        if(checkPalindrome(num)){
            System.out.println(num + " is Palindrome");
        }else {
            System.out.println(num + " not Palindrome");
        }
    }
    public static boolean checkPalindrome(int num){
        int dup = num, reverse = 0;
        while (num > 0){
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return reverse == dup;
    }
}
