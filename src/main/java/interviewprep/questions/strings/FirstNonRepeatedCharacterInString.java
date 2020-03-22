package interviewprep.questions.strings;

import java.util.*;

/*
    Input :
    A string

    Output :
    First Non Repeating Character

    Example :

    Input :
    hello

    Output :
    h

 */
public class FirstNonRepeatedCharacterInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(findFirstNoRepeatingCharacter(input));
    }

    private static Character findFirstNoRepeatingCharacter(String input) {
        Set<Character> characterSet = new HashSet<Character>();
        List<Character> characterList = new ArrayList<Character>();

        for(Character c : input.toCharArray()){
            if(characterSet.contains(c))
                continue;
            if(characterList.contains(c)) {
                characterList.remove(c);
                characterSet.add(c);
            }else {
                characterList.add(c);
            }
        }
        return characterList.size() > 0 ? characterList.get(0) : null;
    }
}

//Link : https://javarevisited.blogspot.com/2014/03/3-ways-to-find-first-non-repeated-character-String-programming-problem.html