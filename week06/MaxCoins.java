import java.util.Arrays;

/**
 * @ClassName:  MaxCoins
 * @Description: 312. 戳气球
 * @link: https://leetcode-cn.com/problems/burst-balloons/
 * @author: liuezhong
 * @date:   2021/9/11 上午11:54    
*/ 

public class MaxCoins {
    /*
    * 方法1：动态规划
    * 时间复杂度：O(n*n*n)，空间复杂度：O(n*n)
    * */

    public int maxCoins1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i < n; i++) {
            val[i] = nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[j] * val[k];
                    dp[i][j] = Math.max(dp[i][j], sum + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    /*
    * 方法2：递归
    * 时间复杂度：O(n*n*n)，空间复杂度：O(n*n)
    * */

    public int[][] result;
    public int[] val;
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        result = new int[n + 2][n + 2];
        val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(result[i], -1);
        }
        return solve(0, n + 1);
    }

    public int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (result[left][right] != -1) {
            return result[left][right];
        }

        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            result[left][right] = Math.max(result[left][right], sum + solve(left, i) + solve(i, right));
        }
        return result[left][right];
    }
}
