import java.util.*;

/**
 * @ClassName:  SolveNQueens
 * @Description: 51. N 皇后
 * @link: https://leetcode-cn.com/problems/n-queens/
 * @author: liuezhong
 * @date:   2021/9/18 下午9:57    
*/ 

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        int[] queen = new int[n];
        getQueen(result, queen, col, 0, pie, na, n);
        return result;
    }
    public void getQueen(List<List<String>> result, int[] queen, Set<Integer> col, int row, Set<Integer> pie, Set<Integer> na, int n) {
        if (row == n) {
            List<String> board = output(queen, n);
            result.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || pie.contains(row + i) || na.contains(row - i)) {
                continue;
            }
            queen[row] = i;
            col.add(i);
            pie.add(row + i);
            na.add(row - i);
            getQueen(result, queen, col, row + 1, pie, na, n);
            col.remove(i);
            pie.remove(row + i);
            na.remove(row - i);
        }
    }
    public List<String> output(int[] queen, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queen[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
