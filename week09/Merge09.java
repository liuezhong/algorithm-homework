
import java.util.Arrays;
/**
 * @ClassName:  Merge
 * @Description: 56. 合并区间
 * @link: https://leetcode-cn.com/problems/merge-intervals/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:45
*/

public class Merge09 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        int[][] result = new int[intervals.length][2];
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int index = -1;
        for (int[] inteval : intervals) {
            if (index == -1 || inteval[0] > result[index][1]) {
                result[++index] = inteval;
            } else {
                result[index][1] = Math.max(result[index][1], inteval[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}
