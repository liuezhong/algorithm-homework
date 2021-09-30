/**
 * @ClassName:  Racecar
 * @Description: 818. 赛车
 * @link: https://leetcode-cn.com/problems/race-car/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:49
*/

public class Racecar {
    public int racecar(int target) {
        int[] dp = new int[target + 2];
        dp[1] = 1;
        dp[2] = 4;
        int k = 2;
        int S = 3;
        for (int i = 3; i <= target; i++) {
            if (i == S) {
                dp[i] = k++;
                S = (1 << k) - 1;
            } else {
                // 情况1：连续k个A后，回退
                dp[i] = k + 1 + dp[S-i];
                // 情况2：连续k-1个A后，回退(0/1/.../k-2)步后，再前进
                for (int back = 0; back <= k-2; back++) {
                    // 回退后还需前进的距离：i+S(back)-S(k-1)
                    int distance = i + (1<<back) - (1<<(k-1));
                    dp[i] = Math.min(dp[i], (k-1) + 2 + back + dp[distance]);
                }
            }
        }
        return dp[target];
    }
}
