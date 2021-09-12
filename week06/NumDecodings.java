/**   
 * @ClassName:  NumDecodings
 * @Description: 91. 解码方法
 * @link: https://leetcode-cn.com/problems/decode-ways/
 * @author: liuezhong
 * @date:   2021/9/12 下午5:51    
*/ 

public class NumDecodings {

    /*
    * 动态规划
    * 时间复杂度：O(n)，空间复杂度：O(n)
    * */

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
