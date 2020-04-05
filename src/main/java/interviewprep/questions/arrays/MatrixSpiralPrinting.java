package interviewprep.questions.arrays;

import java.util.Scanner;

public class MatrixSpiralPrinting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int [][] input = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                input[i][j] = scanner.nextInt();
            }
        }
        printMatrixSpirally(input, rows, cols);
    }

    private static void printMatrixSpirally(int[][] input, int rows, int cols) {
        int left = 0, right = cols, top = 0, bottom = rows;
        while(left<right && top<bottom) {
            for(int i = left; i < right; i++)
                System.out.print(input[top][i] + " ");
            top++;
            for(int i = top; i < bottom; i++)
                System.out.print(input[i][right-1] + " ");
            right--;
            if(top<bottom) {
                for (int i = right-1; i >= left; i--)
                    System.out.print(input[bottom-1][i] + " ");
                bottom--;
            }
            if(left<right){
                for(int i = bottom-1; i >= top; i--)
                    System.out.print(input[i][left] + " ");
                left++;
            }
        }
    }
}


//Link : https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/