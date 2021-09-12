/**
 * @ClassName:  CheckRecord
 * @Description: 552. 学生出勤记录 II
 * @link: https://leetcode-cn.com/problems/student-attendance-record-ii/
 * @author: liuezhong
 * @date:   2021/9/11 下午4:54
*/

public class CheckRecord {
    public int checkRecord(int n) {
        int[][] dp = new int[2][3];
        int MOD = 1000000007;
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int[][] iDp = new int[2][3];
//            第i天为P, 前一天A的个数j可以为[0,1]，L的个数可以是[0,2]
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    iDp[j][0] = (iDp[j][0] + dp[j][k]) % MOD;
                }
            }

//            第i天为A，前一天A的个数只能是0，L的个数可以是[0,2]
            for (int k = 0; k <= 2; k++) {
                iDp[1][0] = (iDp[1][0] + dp[0][k]) % MOD;
            }

//            第天为L，前一天A的个数可以为[0,1],L的个数[0，1]
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    iDp[j][k] = (iDp[j][k] + dp[j][k - 1])% MOD;
                }
            }
            dp = iDp;
        }

        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[j][k]) % MOD;
            }
        }
        return sum;
    }
}
