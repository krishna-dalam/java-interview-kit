package interviewprep.questions.strings;

import sun.usagetracker.UsageTrackerClient;

import java.util.Scanner;

/*
    Input :
    A String to convert to int

    Output :
    int

    Example :

    Input :
    123 [string]

    Output :
    123
 */
public class StringToIntConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(convertToInt(input));
    }

    //Throws Number Parse exception on invalid integer string
    private static int convertToInt(String input) {
        return Integer.parseInt(input);
//        return Integer.valueOf(input);
    }
}

//Link : https://javarevisited.blogspot.com/2011/08/convert-string-to-integer-to-string.html