package Backtracking;

public class NQueens {

    static int count = 0; //for tracking number of solutions 
    public static boolean isSafe(char [][] board, int currRow, int currCol, int N){

        //check row:
        for(int j = 0; j<N; j++){
            if(board[currRow][j]=='Q') return false;
        }
        //check col:
        for(int i = 0; i<N; i++){
            if(board[i][currCol] == 'Q') return false;
        }
        //check left diagonal:
        for(int i = currRow - 1, j = currCol -1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }
        //check right diagonal:
        for(int i = currRow - 1, j = currCol + 1; i>=0 && j<N; i--,j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
    public static void  printPossibleSolutions(char [][] board, int currRow, int N){

        if(currRow == N){
            System.out.println("Solution "+(count+1)+": ");
            printBoard(board, N);
            count++;
            return;
        }

        for(int currCol = 0; currCol<N; currCol++){
            if(isSafe(board,currRow, currCol, N)){
                board[currRow][currCol] = 'Q';
                printPossibleSolutions(board, currRow+1, N);
                board[currRow][currCol] = '.'; //backtrack
            }
        }
    }

    public static void printBoard(char [][] board, int N){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char [][] board = {
            {'.','.','.','.'},
            {'.','.','.','.'},
            {'.','.','.','.'},
            {'.','.','.','.'}
        };

        printPossibleSolutions(board, 0, board.length);
    }
}
