package interviewprep.questions.generic;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++)
            input[i] = scanner.nextInt();
        removeDuplicates(input, n);
    }

    private static void removeDuplicates(int[] input, int length) {
        Arrays.sort(input);
        int[] output = new int[length];
        output[0] = input[0];
        int j=0;
        for (int i=1; i<length; i++)
            if(output[j] != input[i])
                output[++j] = input[i];

        Arrays.stream(output).forEach(System.out::println);

    }
}

// Used collection API
// Link for O(n^2) : https://javaconceptoftheday.com/remove-duplicate-elements-array-java/
// Best case for in place will be to compromise on space or time
// O(n log n) time + O(1) space [sort and remove duplicates] OR O(n) time + O(n) space [using hashing]