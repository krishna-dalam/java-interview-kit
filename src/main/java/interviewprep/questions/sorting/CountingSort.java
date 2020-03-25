package interviewprep.questions.sorting;

import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = scanner.nextInt();
        countingSort(arr, n);
    }

    /*
        1. find max ele
        2. create count arr with size = max and initialize with zeros
        3. update count arr based on actual arr
        4. update count arr incrementally
        5. create arr with size of actual arr
        6. output arr is filled by taking index from count arr and ele from input arr

     */
    private static void countingSort(int[] input, int n) {

        //1
        int max = input[0];
        // find max ele
        for (int i=1; i<n; i++)
            if (input[i] > max)
                max = input[i];
        //2
        int[] count = new int[max+1];

        for(int i=0; i<max; i++)
            count[i] = 0;
        //3
        for(int i=0; i<n; i++)
            count[input[i]]++;

        //4
        for(int i=1; i<max; i++)
            count[i] += count[i-1];

        //5
        int[] output = new int[n];
        for(int i=0; i<n; i++)
            output[count[input[i] - 1]--] = input[i];

        for(int i=0; i<n; i++)
            System.out.println(output[i]);

    }
}
