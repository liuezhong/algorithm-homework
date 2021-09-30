/**
 * @ClassName:  LengthOfLIS
 * @Description: 300. 最长递增子序列
 * @link: https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:52
*/

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
