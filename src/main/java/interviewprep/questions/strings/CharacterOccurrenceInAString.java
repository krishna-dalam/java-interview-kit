package interviewprep.questions.strings;

import java.util.Scanner;

/*
    Input :
    Two lines
    First line is input string
    Second line is character to be searched for

    Output :
    Occurrence of character in string

    Example:
    Input :
    hello world
    l

    Output:
    3
 */
public class CharacterOccurrenceInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char c = scanner.nextLine().charAt(0);
        int charCount = 0; //resetting character count
        for(char ch: input.toCharArray()){
            if(ch == c){
                charCount++;
            }
        }
        System.out.println(charCount);
    }
}


// Link : https://javarevisited.blogspot.com/2012/12/how-to-count-occurrence-of-character-in-String.html