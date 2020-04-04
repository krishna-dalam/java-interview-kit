package interviewprep.questions.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i<n; i++)
            input[i] = scanner.nextInt();
        System.out.println("Before sort :");
        Arrays.stream(input).forEach(ele -> System.out.println(ele));
        selectionSort(input, n);
        System.out.println("After sort :");
        Arrays.stream(input).forEach(ele -> System.out.println(ele));
    }

    private static void selectionSort(int[] input, int n) {

        for(int i=0; i<n-1; i++){
            int min_idx = i;
            for(int j=i+1; j<n; j++)
                if(input[j]>input[min_idx])
                    min_idx = j;
            swap(input, min_idx, i);
        }
    }

    private static void swap(int[] input, int min_idx, int i) {
        int temp = input[min_idx];
        input[min_idx] = input[i];
        input[i] = temp;
    }

}
