package com.dhanunjay.basicmath;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class PrintDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :");
        int num = sc.nextInt();
        printI(num);
        System.out.println();
        printII(num);
    }
    /*
        Brute Force Approach
        Time Complexity : O(N)
        Space Complexity: O(1)
     */
    public static void printI(int num){
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                System.out.print(i + " ");
            }
        }
    }
    /*
        Optimal Approach
        Time Complexity : O(Sqrt(N))
        Space Complexity: O(Number of factors)
     */
    public static void printII(int num){
        SortedSet<Integer> hash = new TreeSet<>();
        for(int i = 1; i * i <= num; i++){
            if(num % i == 0){
                hash.add(i);
                if(num / i != i){
                    hash.add(num / i);
                }
            }
        }
        System.out.println(hash);
    }
}
