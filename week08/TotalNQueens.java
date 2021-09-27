import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:  TotalNQueens
 * @Description: 52. N皇后 II
 * @link: https://leetcode-cn.com/problems/n-queens-ii/
 * @author: liuezhong
 * @date:   2021/9/25 上午11:08    
*/ 

public class TotalNQueens {
    /*
    * 方法1：递归
    * 时间复杂度：O(N!)，空间复杂度：O(N)，N为皇后数量
    * */

    public int totalNQueens1(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        return getTotalQueens(0, col, pie, na, n);
    }

    private int getTotalQueens(int row, Set<Integer> col, Set<Integer> pie, Set<Integer> na, int n) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || pie.contains(row - i) || na.contains(row + i)) {
                continue;
            }
            col.add(i);
            pie.add(row - i);
            na.add(row + i);
            count += getTotalQueens(row + 1, col, pie, na, n);
            col.remove(i);
            pie.remove(row - i);
            na.remove(row + i);
        }
        return count;
    }

    /*
    * 方法2：位运算
    * 时间复杂度：O(N!)，空间复杂度：O(N)，N为皇后数量
    * */

    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            count += solve(n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
        }
        return count;
    }

    public static void main(String[] args) {
        TotalNQueens t = new TotalNQueens();
        t.totalNQueens(4);
    }
}
