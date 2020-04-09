package interviewprep.questions.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i<n; i++)
            input[i] = scanner.nextInt();
        heapSort(input);
        Arrays.stream(input).forEach(ele -> System.out.println(ele));
    }

    private static void heapSort(int[] input) {
        //convert array into heap
        int n = input.length;
        for(int i= n/2 - 1; i>=0; i--)
            heapify(input, n, i);
        for(int i=n-1; i>0; i--){
            int temp = input[i];
            input[i] = input[0];
            input[0] = temp;
            heapify(input, i, 0);
        }

    }

    private static void heapify(int[] input, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l<n && input[l]> input[largest])
            largest = l;

        if(r<n && input[r]>input[largest])
            largest = r;

        if(largest!=i){
            int temp = input[i];
            input[i] = input[largest];
            input[largest] = temp;

            heapify(input, n, largest);
        }
    }

}


//Link : https://www.geeksforgeeks.org/heap-sort/