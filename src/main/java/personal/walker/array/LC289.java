package personal.walker.array;

import personal.walker.Solution;

public class LC289 implements Solution {
    @Override
    public void runTestCases() {

    }

    public void gameOfLife(int[][] board) {
        // 2 : dead -> live
        // 3 : live -> dead
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCount = 0;
                if (i > 0 && j > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 3)) {
                    liveCount++;
                }
                if (i > 0 && (board[i - 1][j] == 1 || board[i - 1][j] == 3)) {
                    liveCount++;
                }
                if (j < board[0].length - 1 && i > 0 && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 3)) {
                    liveCount++;
                }
                if (i < board.length - 1 && (board[i + 1][j] == 1 || board[i + 1][j] == 3)) {
                    liveCount++;
                }
                if (j < board[0].length - 1 && (board[i][j + 1] == 1 || board[i][j + 1] == 3)) {
                    liveCount++;
                }
                if (j < board[0].length - 1 && i < board.length - 1 && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 3)) {
                    liveCount++;
                }

                if (j > 0 && i < board.length - 1 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 3)) {
                    liveCount++;
                }
                if (j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == 3)) {
                    liveCount++;
                }
                if (liveCount == 3 && board[i][j] == 0){
                    board[i][j] = 2;
                }
               if  (board[i][j] == 1 && (liveCount > 3 || liveCount < 2)){
                   board[i][j] = 3;
               }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3){
                    board[i][j] = 0;
                }
                if (board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }

}
