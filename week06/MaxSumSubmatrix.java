import java.util.TreeSet;

/**
 * @ClassName:  MaxSumSubmatrix
 * @Description: 363. 矩形区域不超过 K 的最大数值和
 * @link: https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * @author: liuezhong
 * @date:   2021/9/11 下午4:56    
*/ 

public class MaxSumSubmatrix {
    public int maxSumSubmatrix(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int result = Integer.MIN_VALUE;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        for (int top = 1; top <= m; top++) {
            for (int bottom = top; bottom <= m; bottom++) {
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                for (int r = 1; r <= n; r++) {
                    int right = sum[bottom][r] - sum[top - 1][r];
                    Integer left = treeSet.ceiling(right - k);
                    if (left != null) {
                        int cur = right - left;
                        result = Math.max(result, cur);
                    }
                    treeSet.add(right);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSumSubmatrix m = new MaxSumSubmatrix();
        m.maxSumSubmatrix(new int[][]{{1,0,1},{0,-2,3}}, 3);
    }
}
