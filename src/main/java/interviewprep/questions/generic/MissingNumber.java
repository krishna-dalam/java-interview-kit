package interviewprep.questions.generic;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i<n; i++)
            input[i] = scanner.nextInt();
        System.out.println(missingNumber(input, n));
    }

    // Using XOR
    // XOR of 2 numbers result in zero
    // Find XOR of input arr and arr with length +1
    // Find XOR of both resultant XOR's which is the solution
    private static int missingNumber(int[] input, int n) {
        int xor = 0;
        for (int i: input)
            xor ^= i;
        for (int i=1; i<=n+1; i++)
            xor ^= i;
        return xor;
    }
}
