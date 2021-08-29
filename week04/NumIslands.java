import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName:  NumIslands
 * @Description: 200. 岛屿数量
 * @link: https://leetcode-cn.com/problems/number-of-islands/
 * @author: liuezhong
 * @date:   2021/8/29 上午11:07    
*/ 

public class NumIslands {
    /*
    * 方法1：深度有限遍历
    * 时间复杂度：O(MN)，空间复杂度：O(MN)
    * */

    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i, j + 1);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i - 1, j);
        }
    }

    /*
    * 方法2：
    * 时间复杂度：O(MN)，空间复杂度：O(min(M,N))
    * */

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int colCount = grid[0].length;
        int rowCount = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * colCount + j);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int x = id / colCount;
                        int y = id % colCount;
                        if (y + 1 < colCount && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(x * colCount + y + 1);
                        }
                        if (x + 1 < rowCount && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add((x + 1) * colCount + y);
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(x * colCount + y - 1);
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add((x - 1) * colCount + y);
                        }
                    }

                }
            }
        }
        return count;
    }
}
