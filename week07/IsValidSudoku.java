import java.util.HashMap;

/**
 * @ClassName:  IsValidSudoku
 * @Description: 36. 有效的数独
 * @link: https://leetcode-cn.com/problems/valid-sudoku/
 * @author: liuezhong
 * @date:   2021/9/18 下午10:01    
*/ 

public class IsValidSudoku {
    /*
    * 方法1：数组
    * 时间复杂度：O(m*n)，空间复杂度：O(m*n)，m为board的行数，n为board的列数
    * */

    public boolean isValidSudoku1(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] block = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int data = board[i][j] - '0';
                    int blockIndex = 3 * (i / 3) + j / 3;
                    if (row[i][data] == 1 || col[j][data] == 1 || block[blockIndex][data] == 1) {
                        return false;
                    }
                    row[i][data] = 1;
                    col[j][data] = 1;
                    block[blockIndex][data] = 1;
                }
            }
        }
        return true;
    }

    /*
    * 方法2：map
    * 时间复杂度：O(m * n)，空间复杂度：O(m*n),m为board的行数，n为board的列数
    * */

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] colMap = new HashMap[9];
        HashMap<Integer, Integer>[] rowMap = new HashMap[9];
        HashMap<Integer, Integer>[] blockMap = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            colMap[i] = new HashMap<>();
            rowMap[i] = new HashMap<>();
            blockMap[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    Integer data = board[i][j] - '0';
                    int blockIndex = (i / 3) * 3 + j / 3;
                    rowMap[i].put(data, rowMap[i].getOrDefault(data, 0) + 1);
                    colMap[j].put(data, colMap[j].getOrDefault(data, 0) + 1);
                    blockMap[blockIndex].put(data, blockMap[blockIndex].getOrDefault(data, 0) + 1);

                    if (rowMap[i].get(data) > 1 || colMap[j].get(data) > 1 || blockMap[blockIndex].get(data) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
