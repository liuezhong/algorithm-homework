import java.util.Arrays;

/**
 * @ClassName:  MaximalSquare
 * @Description: 221. 最大正方形
 * @link: https://leetcode-cn.com/problems/maximal-square/
 * @author: liuezhong
 * @date:   2021/9/12 下午6:09    
*/ 

public class MaximalSquare {
    /*
    * 动态规划
    * 时间复杂度：O(m*n)，空间复杂度：O(m*n)
    * */

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxSide = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }

            }
        }
        return maxSide * maxSide;
    }
}
