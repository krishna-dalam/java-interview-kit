package interviewprep.questions.strings;

/*
       Given an input string, reverse the string word by word.

       Example 1:
       Input: "the sky is blue"
       Output: "blue is sky the"

       Example 2:
       Input: "  hello world!  "
       Output: "world! hello"

       Example 3:
       Input: "a good   example"
       Output: "example good a"
       Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String res= "";
        String str = " word1     word2     word3    word4 word5 word6      ";
        String[] arrOfStr = str.split("[ ]+");

        int len = arrOfStr.length;
        for (int i=0; i<len; i++)
            res = res.concat(arrOfStr[len-i-1]).concat(" ");
        System.out.print(res.trim());
    }
}
