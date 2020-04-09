package interviewprep.questions.generic;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        isPrime(n);
    }

    private static void isPrime(int n) {
        if(n<2)
            System.out.println("Not Prime");
        else {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.println("Prime");
            else
                System.out.println("Not a prime");
        }
    }
}
