package interviewprep.questions.sorting;

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

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scanner.nextInt();
        mergeSort(arr, n);
        for(int i=0; i<n; i++)
            System.out.println(arr[i]);
    }

    private static void mergeSort(int[] arr, int n){
        mergeSort(arr, 0, n-1);
    }

    private static void mergeSort(int[] arr, int low, int high){
        int mid = (low + high)/2;
        if(low<high){
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
        }

        int i=0, first = low, second = mid+1;
        int[] tmp = new int[high - low + 1];

        while(first <= mid && second <= high)
            tmp[i++] = arr[first] < arr[second] ? arr[first++] : arr[second++];

        while(first <= mid)
            tmp[i++] = arr[first++];

        while (second <= high)
            tmp[i++] = arr[second++];

        i = 0;
        while (low <= high)
            arr[low++] = tmp[i++];
    }

}


// More clear documentation is given in following link
// Link : https://www.java67.com/2018/03/mergesort-in-java-algorithm-example-and.html
