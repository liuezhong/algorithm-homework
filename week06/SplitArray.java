import java.util.Arrays;

/**
 * @ClassName:  SplitArray
 * @Description: 
 * @link:
 * @author: liuezhong
 * @date:   2021/9/11 下午4:56    
*/ 

public class SplitArray {
    /*
    * 方法1：动态规划
    * 时间复杂度：O(n*n*m)，空间复杂度：O(n*m)
    * */

    public int splitArray1(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] sum = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[n][m];
    }

    /*
    * 方法2：二分查找
    * 时间复杂度：O(log(n * log(sum))，空间复杂度：O(1),其中n为nums的长度，sum为nums的元素之和
    * */

    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (split(nums, mid) > m) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    private int split(int[] nums, int maxSectionSum) {
        int split = 1;
        int sectionNum = 0;
        for (int num : nums) {
            if (sectionNum + num > maxSectionSum) {
                sectionNum = 0;
                split++;
            }
            sectionNum += num;
        }
        return split;
    }


}
