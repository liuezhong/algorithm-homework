/**   
 * @ClassName:  SolveSudoku
 * @Description: 37. 解数独
 * @link: https://leetcode-cn.com/problems/sudoku-solver/
 * @author: liuezhong
 * @date:   2021/9/18 下午10:09    
*/ 

public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col, char data) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == data) {
                return false;
            }
            if (board[i][col] == data) {
                return false;
            }
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == data) {
                return false;
            }
        }
        return true;
    }

}
