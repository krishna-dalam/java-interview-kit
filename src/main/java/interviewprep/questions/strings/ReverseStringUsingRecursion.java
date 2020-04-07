package interviewprep.questions.strings;

import java.util.Scanner;

public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("String before: " + input);
        String reversedInput = reverseString(input);
        System.out.println("String after: "+ reversedInput);
    }

    private static String reverseString(String input) {
        if(input.isEmpty())
            return input;
        return reverseString(input.substring(1)) + input.charAt(0);
    }
}
