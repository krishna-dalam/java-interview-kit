package interviewprep.questions.strings;

import java.util.Scanner;

public class StringPermutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printPermutations(input, "");
    }

    private static void printPermutations(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            String remainingString = str.substring(0, i) + str.substring(i+1);
            printPermutations(remainingString, ans+c);
        }
    }
}
