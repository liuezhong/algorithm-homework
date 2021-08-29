import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName:  UpdateBoard
 * @Description: 529. 扫雷游戏
 * @link: https://leetcode-cn.com/problems/minesweeper/description/
 * @author: liuezhong
 * @date:   2021/8/28 下午2:45    
*/ 

public class UpdateBoard {
    /*
    * 方法1：dfs
    * 时间复杂度：O(mn)，空间复杂度：O(mn)
    * */

    public char[][] updateBoard1(char[][] board, int[] click) {
        if (board == null || board.length == 0) {
            return board;
        }
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }else {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int[] dirX = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
        int[] dirY = new int[]{1, 0, -1, 0, 1, -1, 1, -1};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }

            if (board[tx][ty] == 'M') {
                count++;
            }
        }

        if (count > 0) {
            board[x][y] = (char)('0' + count);
        }else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }

    /*
    * 方法2：bfs
    * 时间复杂度：O(mn)，空间复杂度：O(mn)
    * */

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) {
            return board;
        }
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            bfs(board, x, y);
        }
        return board;
    }

    private void bfs(char[][] board, int x, int y) {
        int[] dirX = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
        int[] dirY = new int[]{1, 0, -1, 0, 1, -1, 1, -1};

        int rowCount = board.length;
        int colCount = board[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * colCount + y);
        boolean[][] visited = new boolean[board.length][board[0].length];
        while (!queue.isEmpty()) {
            int id = queue.remove();
            int tx = id / colCount;
            int ty = id % colCount;
            int count = 0;
            for (int i = 0; i < 8; i++) {
                int nextX = tx + dirX[i];
                int nextY = ty + dirY[i];
                if (nextX < 0 || nextX >= rowCount || nextY < 0 || nextY >= colCount) {
                    continue;
                }
                if (board[nextX][nextY] == 'M') {
                    count++;
                }
            }
            if (count > 0) {
                board[tx][ty] = (char)('0' + count);
            } else {
                board[tx][ty] = 'B';
                for (int i = 0; i < 8; i++) {
                    int nextX = tx + dirX[i];
                    int nextY = ty + dirY[i];
                    if (nextX < 0 || nextX >= rowCount || nextY < 0 || nextY >= colCount || visited[nextX][nextY] || board[nextX][nextY] != 'E') {
                        continue;
                    }
                    queue.add(nextX * colCount + nextY);
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
