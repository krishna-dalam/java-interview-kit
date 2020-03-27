package interviewprep.questions.generic;


import java.util.Scanner;

//Given arr with elements from 0 - n-1 where size of arr is n
public class FindDuplicates {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++)
            input[i] = scanner.nextInt();


        for (int i = 0; i < input.length; i++) {
            input[input[i] %  input.length] += input.length;
        }
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < input.length; i++) {
            if (input[i] >= input.length*2) {
                System.out.println(i + " ");
            }
        }
    }
}


//Link : https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/