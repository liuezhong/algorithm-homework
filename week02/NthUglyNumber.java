import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName:  NthUglyNumber
 * @Description: 丑数
 * @link: https://leetcode-cn.com/problems/chou-shu-lcof/
 * @author: liuezhong
*/ 

public class NthUglyNumber {

//    方法1：优先队列

    public int nthUglyNumber1(int n) {
        Set<Long> seen = new HashSet<>();
        int[] factors = new int[]{2, 3, 5};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        long ugly = 0L;
        queue.add(1L);
        seen.add(1L);
        for (int i = 0; i < n; i++) {
            ugly = queue.poll();
            for (int factor : factors) {
                Long cur = factor * ugly;
                if (seen.add(cur)){
                    queue.add(cur);
                }
            }
        }
        return (int)ugly;
    }

//    方法2：动态规划

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[1] = 1;
        int dp2 = 1;
        int dp3 = 1;
        int dp5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = 2 * dp[dp2];
            int num3 = 3 * dp[dp3];
            int num5 = 5 * dp[dp5];
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                dp2++;
            }
            if (dp[i] == num3) {
                dp3++;
            }
            if (dp[i] == num5) {
                dp5++;
            }
        }
        return dp[n];
    }
}
