/**
 * @ClassName:  NumDistinct
 * @Description: 115. 不同的子序列
 * @link: https://leetcode-cn.com/problems/distinct-subsequences/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:53
*/

public class NumDistinct {
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return 0;
        }
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
