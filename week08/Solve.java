/**   
 * @ClassName:  Solve
 * @Description: 130. 被围绕的区域
 * @link: https://leetcode-cn.com/problems/surrounded-regions/
 * @author: liuezhong
 * @date:   2021/9/25 下午4:58    
*/ 

public class Solve {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfsMarking(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfsMarking(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfsMarking(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                dfsMarking(board, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

            }
        }
    }

    private void dfsMarking(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfsMarking(board, x, y + 1);
        dfsMarking(board, x + 1, y);
        dfsMarking(board, x, y - 1);
        dfsMarking(board, x - 1, y);
    }
}
