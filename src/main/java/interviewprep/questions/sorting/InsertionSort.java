package interviewprep.questions.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i<n; i++)
            input[i] = scanner.nextInt();
        System.out.println("Before sort :");
        Arrays.stream(input).forEach(ele -> System.out.println(ele));
        insertionSort(input, n);
        System.out.println("After sort :");
        Arrays.stream(input).forEach(ele -> System.out.println(ele));
    }

    private static void insertionSort(int[] input, int n) {
        for(int i=1; i<n; i++){
            int key = input[i];
            int j=i-1;
            while(j>=0 && input[j]>key){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = key;
        }
    }
}

//Link : https://www.geeksforgeeks.org/insertion-sort/
