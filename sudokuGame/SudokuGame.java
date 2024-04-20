package sudokuGame;
import java.util.Scanner;
public class SudokuGame {
    public static boolean  solveSudoku(int board[][])
    {
        for(int i=0;i< board.length;i++)
        {
            for(int j=0;j< board.length;j++)
            {
                if(board[i][j]==0) {
                    for (int k = 1; k <= board.length; k++) {
                        if(validsudokuNUm(board,k,i,j)) {
                            board[i][j] = k;
                            if(solveSudoku(board))
                                return true;
                            else board[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }

      return true;
    }
    public static boolean validsudokuNUm(int board[][],int number,int row,int column)
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[row][i]==number)
                return false;
            if(board[i][column]==number)
                return false;
            int sqrtN = (int) Math.sqrt(board.length);
            int startRow = row - row % sqrtN;
            int startCol = column - column % sqrtN;
            for (int k = 0; k < sqrtN; k++) {
                for (int j = 0; j < sqrtN; j++) {
                    if (board[k + startRow][j + startCol] == number) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
       /* int matrix[][]={{1,2,0,3,0,4,0,5,6},
        {7,0,0,0,0,6,0,0,1},
        {0,0,0,0,0,0,0,0,0},
        {0,8,0,4,0,9,0,2,0},
        {0,0,0,0,6,0,0,0,0},
        {0,3,0,5,0,1,0,8,0},
        {0,0,0,0,0,0,0,0,0},
        {9,0,0,2,0,0,0,0,8},
        {8,4,0,6,0,7,0,1,9}};*/
        System.out.println("Enter the size of matrix");
        int size= sc.nextInt();
        System.out.println("Enter value:");
        String inputLine=sc.next();
        int index=0;
        int matrix[][]=new int[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                matrix[i][j]=Character.getNumericValue(inputLine.charAt(index));
                index++;
            }

        }
        System.out.println("Before:");
        printBoard(matrix);
        System.out.println();
        System.out.println();
        if(solveSudoku(matrix)) {
            System.out.println("solved sudoku  !!!");
            printBoard(matrix);
        }
        else {
            System.out.println("Invalid sudoku board");
        }
    }

    private static void printBoard(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
        {

            for(int j=0;j<matrix[i].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }


}
