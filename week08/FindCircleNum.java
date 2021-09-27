import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName:  FindCircleNum
 * @Description: 547. 省份数量
 * @link: https://leetcode-cn.com/problems/number-of-provinces/
 * @author: liuezhong
 * @date:   2021/9/25 下午3:48    
*/ 

public class FindCircleNum {
    /*
    * 方法1：DFS
    * */

    public int findCircleNum1(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    isConnected[i][j] = 0;
                    count++;
                    dfsMarking(isConnected, j, i);
                }
            }
        }
        return count;
    }

    private void dfsMarking(int[][] isConnected, int row, int col) {
        for (int i = 0; i < isConnected[0].length; i++) {
            if (isConnected[row][i] == 1) {
                isConnected[row][i] = 0;
                dfsMarking(isConnected, i, row);
            }
        }
    }

    /*
    * 方法1：BFS
    * */

    public int findCircleNum2(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                queue.add(i);
                count++;
                while (!queue.isEmpty()) {
                    int row = queue.remove();
                    visited[row] = true;
                    for (int j = 0; j < isConnected[0].length; j++) {
                        if (isConnected[row][j] == 1 && !visited[j]) {
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return count;
    }

    /*
    * 方法3：并查集
    * */

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    private void union(int[] parent, int p, int q) {
        int rootP = find(parent, p);
        int rootQ = find(parent,q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
    }

    private int find(int[] parent, int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
