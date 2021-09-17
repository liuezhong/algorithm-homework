/**   
 * @ClassName:  ClimbStairs
 * @Description: 70. 爬楼梯
 * @link: https://leetcode-cn.com/problems/climbing-stairs/
 * @author: liuezhong
 * @date:   2021/9/17 下午11:18    
*/ 

public class ClimbStairs {
    /*
    * 方法1：滚动数组
    * 时间复杂度：O(n)，空间复杂度：O(1)
    * */
    
    public int climbStairs1(int n) {
        int prev = 0;
        int cur = 0;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            prev = cur;
            cur = result;
            result = prev + cur;
        }
        return result;
    }

    /*
    * 方法2：
    * 时间复杂度：O(n)，空间复杂度：O(n)
    * */

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
