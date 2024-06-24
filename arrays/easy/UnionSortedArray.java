package com.dhanunjay.arrays.easy;

import java.util.*;

public class UnionSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of first array :");
        int n = sc.nextInt();
        System.out.print("Enter first array elements: ");
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter size of second array :");
        int m = sc.nextInt();
        System.out.print("Enter second array elements: ");
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++){
            arr2[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        unionI(arr1, arr2);
        unionII(arr1, arr2);
        unionIII(arr1, arr2);
    }
    /*
        Time Complexity: O( (m+n)log(m+n) )
        Space Complexity: O(m + n)
     */
    public static void unionI(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i: arr1){
            int value = hash.getOrDefault(i, 0);
            hash.put(i, value + 1);
        }
        for(int j : arr2){
            int value = hash.getOrDefault(j, 0);
            hash.put(j, value + 1);
        }
        System.out.println(hash.keySet());
    }
    /*
       Time Complexity: O( (m+n)log(m+n) )
       Space Complexity: O(m + n)
    */
    public static void unionII(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        for(int i: arr1){
            set.add(i);
        }
        for(int i: arr2){
            set.add(i);
        }
        System.out.println(set);
    }
    public static void unionIII(int[] arr1, int[] arr2){
        int i = 0, j = 0, n = arr1.length, m = arr2.length;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < n && j < m){
            if(arr1[i] <= arr2[j]){
                if(!list.contains(arr1[i])){
                    list.add(arr1[i]);
                }
                i++;
            }else{
                if(!list.contains(arr2[j])){
                    list.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n){
            if(!list.contains(arr1[i])){
                list.add(arr1[i]);
            }
            i++;
        }
        while (j < m){
            if(!list.contains(arr2[j])){
                list.add(arr2[j]);
            }
            j++;
        }
        System.out.println(list);
    }
}
