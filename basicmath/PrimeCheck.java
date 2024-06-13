package com.dhanunjay.basicmath;

import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :");
        int num = sc.nextInt();
        primeI(num);
        primeII(num);
    }
    /*
        Brute Force Approach
        Time Complexity: O(N)
        Space Complexity: O(1)
     */
    public static void primeI(int num){
        boolean isPrime = true;
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println(num + " is prime");
        }else{
            System.out.println(num + " is not prime");
        }
    }
    public static void primeII(int num){
        boolean isPrime = true;
        for(int i = 2; i * i < num; i++){
            if(num % i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println(num + " is prime");
        }else{
            System.out.println(num + " is not prime");
        }
    }
}
