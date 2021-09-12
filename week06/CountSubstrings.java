/**
 * @ClassName:  CountSubstrings
 * @Description: 647. 回文子串
 * @link: https://leetcode-cn.com/problems/palindromic-substrings/
 * @author: liuezhong
 * @date:   2021/9/12 下午7:30
*/

public class CountSubstrings {
    /*
    *
    * 时间复杂度：O(n*n)，空间复杂度：O(n*n)
    * */

    public int countSubstrings(String s) {
        int result = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
