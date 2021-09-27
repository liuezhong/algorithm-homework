import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName:  NumIslands
 * @Description: 200. 岛屿数量
 * @link: https://leetcode-cn.com/problems/number-of-islands/
 * @author: liuezhong
 * @date:   2021/9/25 下午4:16
*/

public class NumIslands08 {
    /*
    * 方法1：DFS
    * */

    private int[] dirX = new int[]{0, 1, 0, -1};
    private int[] dirY = new int[]{1, 0, -1, 0};
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = 0;
                    dfsMarking(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfsMarking(char[][] grid, int x, int y) {
        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] != '0') {
                grid[nextX][nextY] = '0';
                dfsMarking(grid, nextX, nextY);
            }
        }
    }

    /*
    * 方法2：BFS
    * */

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    count++;
                    Queue<Integer> queue = new LinkedList();
                    queue.add(i * n + j);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int x = id / n;
                        int y = id % n;
                        if (y + 1 < n && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(x * n + y + 1);
                        }
                        if (x + 1 < m && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add((x + 1) * n + y);
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(x * n + y - 1);
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add((x - 1) * n + y);
                        }
                    }
                }
            }
        }
        return count;
    }
}
