/**   
 * @ClassName:  LongestPalindrome
 * @Description: 5. 最长回文子串
 * @link: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author: liuezhong
 * @date:   2021/10/16 下午3:01    
*/ 

public class LongestPalindrome {
    /*
    * 方法1：动态规划
    * 时间复杂度：O(n * n)，空间复杂度：O(n * n)
    * */

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int begin = 0;
        int maxLen = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    /*
    * 方法2：中心扩展法
    * 时间复杂度：O(n * n)，空间复杂度：O(1)
    * */

    public int maxLen = 0;
    public int begin = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            expanderCounter(s, i, i);
            expanderCounter(s, i, i + 1);
        }
        return s.substring(begin, begin + maxLen);
    }

    private void expanderCounter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > maxLen) {
            maxLen = right - left - 1;
            begin = left + 1;
        }
    }
}
