import java.util.*;

/**
 * @ClassName:  SolveNQueens08
 * @Description: 51. N 皇后
 * @link: https://leetcode-cn.com/problems/n-queens/description/
 * @author: liuezhong
 * @date:   2021/9/25 下午1:57    
*/ 

public class SolveNQueens08 {
    /*
    * 方法1：递归
    * 时间复杂度：O(N!)，空间复杂度：O(N)，N为皇后数量
    * */

    public List<List<String>> solveNQueens1(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        int[] queens = new int[n];
        getQueens(result, 0, col, pie, na, queens, n);
        return result;
    }

    private void getQueens(List<List<String>> result, int row, Set<Integer> col, Set<Integer> pie, Set<Integer> na, int[] queens, int n) {
        if (row == n) {
            List<String> board = output(queens, n);
            result.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || pie.contains(row - i) || na.contains(row + i)) {
                continue;
            }
            queens[row] = i;
            col.add(i);
            pie.add(row - i);
            na.add(row + i);
            getQueens(result, row + 1, col, pie, na, queens, n);
            col.remove(i);
            pie.remove(row - i);
            na.remove(row + i);
        }
    }

    private List<String> output(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    /*
    * 方法2：位运算
    * 时间复杂度：O(N!)，空间复杂度：O(N)，N为皇后数量
    * */

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<List<String>>();
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
            return;
        }
        int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            int column = Integer.bitCount(position - 1);
            queens[row] = column;
            solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            queens[row] = -1;
        }

    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        SolveNQueens08 s = new SolveNQueens08();
        s.solveNQueens(4);
    }
}
