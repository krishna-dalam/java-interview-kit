package interviewprep.questions;

import java.util.*;

/*
    Input :
    First line [ N ] - number of integers to be sorted
    Followed by N integers to be sorted

    Output :
    Sorted N numbers

    Example :
    Input :
    3
    6
    5
    4

    Output :
    4
    5
    6
*/
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scanner.nextInt();
        bubbleSort(arr, n);
        for(int i=0; i<n; i++)
            System.out.println(arr[i]);
    }

    private static void bubbleSort(int[] arr, int n){
        //for each iteration of i, ith element will be in sorted order
        //example: After first iteration least element will be in first position
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] > arr[j])
                    swap(arr, i, j);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        //without using temp variable
        //If the integer is max we need to handle overflow [not handled here]
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

//    private static void swap(int[] arr, int i, int j) {
//        //with using temp variable
//        //No need to handle overflow
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

}

// More clear documentation is given in following link
// Link : https://javarevisited.blogspot.com/2014/08/bubble-sort-algorithm-in-java-with.html#axzz5ArdIFI7y


















