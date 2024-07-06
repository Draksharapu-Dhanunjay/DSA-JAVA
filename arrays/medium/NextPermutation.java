package com.dhanunjay.arrays.medium;

import java.util.*;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
//        permutationI(arr);
        permutationII(arr);
    }
    /*
        Time Complexity: O(N!)
        Space Complexity: O(N!)
     */
    public static void permutationI(int[] arr ){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        permutationList(0, arr, ans);
        for(int i = 0; i < ans.size(); i++){
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                    String s1 = list1.toString();
                    String s2 = list2.toString();
                    return s1.compareTo(s2);
                }
            });
        }
        int i;
        ArrayList<Integer> ls = new ArrayList<>();
        for(int j : arr){
            ls.add(j);
        }
        int j = 0;
        for(ArrayList<Integer> list: ans){
            if(list.equals(ls)){
                j++;
                break;
            }
        }
        if(j == ans.size()){
            System.out.println(ans.get(0));
        }else{
            System.out.println(ans.get(j));
        }
    }

    public static void permutationList(int index, int[] arr, ArrayList<ArrayList<Integer>> ans){
        if(index == arr.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i: arr){
                list.add(i);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < arr.length; i++){
            swap(index, i, arr);
            permutationList(index + 1, arr, ans);
            swap(index, i, arr);
        }
    }
    public static void swap(int first, int second, int[] arr){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    /*
        Optimal Approach
        Time Complexity:  O(3N)
        Space Complexity: O(1)
     */

    public static void permutationII(int[] arr){
        int index = -1, n = arr.length ;
        for(int i = n - 2; i > 0; i--){
            if(arr[i] < arr[i + 1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(0, n - 1, arr);
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i = n - 1; i > index; i--){
            if(arr[i] > arr[index]){
                swap(i, index, arr);
                break;
            }
        }
        reverse(index + 1, n - 1, arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void reverse(int start, int end, int[] arr){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
