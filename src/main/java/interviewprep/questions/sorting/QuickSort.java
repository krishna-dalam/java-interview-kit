package interviewprep.questions.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++)
            input[i] = scanner.nextInt();
        quickSort(input, 0, n-1);

        Arrays.stream(input).forEach(e -> System.out.println(e));
    }

    private static void quickSort(int[] input, int low, int high) {
        if(input == null || input.length == 0)
               return;

        if(low>=high)
            return;

        int mid = low + (high-low)/2;
        int pivot = input[mid];

        int start = low;
        int end   = high;

        while(start<=end){
            while (input[start] < pivot)
                start++;
            while (input[end] > pivot)
                end--;

            if(start<=end){
                int temp = input[start];
                input[start] = input[end];
                input[end] = temp;
                start++;
                end--;
            }
        }

        if(low < end)
            quickSort(input, low, end);

        if(high > start)
            quickSort(input, start, high);
    }
}
