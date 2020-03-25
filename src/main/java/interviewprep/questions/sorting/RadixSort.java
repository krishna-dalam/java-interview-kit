package interviewprep.questions.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] input = new int[len];
        for (int i=0; i< len; i++)
            input[i] = scanner.nextInt();
        radixSort(input, len);
    }

    private static void radixSort(int[] input, int len) {
        int max = getMax(input, len);
        for(int place=1; max/place > 0; place*=10)
            countingSort(input, len, place);
        Arrays.stream(input).forEach(System.out::println);
    }

    private static void countingSort(int[] input, int len, int place) {
        int[] output = new int[len + 1];
        int max = getMax(input, len);
        int[] count = new int[max + 1];

        for (int i=0; i<len; i++)
            count[(input[i]/place) % 10]++;


        for (int i = 1; i < max; i++)
            count[i] += count[i - 1];

        for (int i = len - 1; i >= 0; i--) {
            output[count[(input[i] / place) % 10] - 1] = input[i];
            count[(input[i] / place) % 10]--;
        }

        for(int i=0; i<len; i++)
            input[i] = output[i];
    }

    private static int getMax(int[] input, int len) {
        int max = input[0];
        for (int i=0; i<len; i++)
            if (input[i] > max)
                max = input[i];
        return max;
    }
}
