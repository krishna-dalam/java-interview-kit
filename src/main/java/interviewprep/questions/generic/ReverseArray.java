package interviewprep.questions.generic;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] input = new int[length];
        for (int i=0; i<length; i++)
            input[i] = scanner.nextInt();
        reverse(input, length);
    }

    private static void reverse(int[] input, int length) {
        int temp;
        for(int index1=0; index1<length/2; index1++){
            int index2 = length-index1-1;
            temp          = input[index1];
            input[index1] = input[index2];
            input[index2] = temp;
        }
        Arrays.stream(input).forEach(System.out::println);
    }
}

//Link tp Apache util method : https://javarevisited.blogspot.com/2013/03/how-to-reverse-array-in-java-int-String-array-example.html
