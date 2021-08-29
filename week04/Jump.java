/**   
 * @ClassName:  Jump
 * @Description: 45. 跳跃游戏 II
 * @link: https://leetcode-cn.com/problems/jump-game-ii/
 * @author: liuezhong
 * @date:   2021/8/28 下午4:51    
*/ 

public class Jump {
    /*
    *
    * 时间复杂度：O(N)，空间复杂度：O(1)
    * */

    public int jump(int[] nums) {
        int maxPosition = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
