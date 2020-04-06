package interviewprep.questions.search;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i<n; i++)
            input[i] = scanner.nextInt();

        int val = scanner.nextInt();

        int result = binarySearch(input, 0, n-1, val);
        if(result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element is found at index : "+ result);
    }

    private static int binarySearch(int[] input, int left, int right, int val) {
        if(right>=left){
            int mid = left + (right - left)/2;
            if(input[mid] == val)
                return mid;
            if(input[mid]>val)
                return binarySearch(input, left, mid-1, val);

            return binarySearch(input, mid+1, right, val);
        }
        return -1;
    }
}


//Link : https://www.geeksforgeeks.org/binary-search/
