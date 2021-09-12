/**   
 * @ClassName:  CanCross
 * @Description: 403. 青蛙过河
 * @link: https://leetcode-cn.com/problems/frog-jump/
 * @author: liuezhong
 * @date:   2021/9/11 下午4:55    
*/ 

public class CanCross {

    /*
    * 方法1：动态规划
    * 时间复杂度：O(n*n)，空间复杂度：O(n*n)
    * */

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[1][1] = true;
        for (int i= 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k <= j + 1) {
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (dp[n - 1][i]) {
                return true;
            }
        }
        return false;
    }
}
