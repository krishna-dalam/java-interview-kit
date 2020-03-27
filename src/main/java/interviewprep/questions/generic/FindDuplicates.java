package interviewprep.questions.generic;


//Given arr with elements from 0 - n-1 where size of arr is n
public class FindDuplicates {
    public static void main(String args[]) {
        int numRay[] = {0, 4, 3, 2, 7, 8, 2, 3, 1};

        for (int i = 0; i < numRay.length; i++) {
            int val = numRay[i] %  numRay.length;
            System.out.println(val);
            numRay[numRay[i] %  numRay.length] += numRay.length;
        }
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < numRay.length; i++) {
            if (numRay[i] >= numRay.length*2) {
                System.out.println(i + " ");
            }
        }
    }
}


//Link : https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/