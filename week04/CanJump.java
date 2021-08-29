/**   
 * @ClassName:  CanJump
 * @Description: 55. 跳跃游戏
 * @link: https://leetcode-cn.com/problems/jump-game/
 * @author: liuezhong
 * @date:   2021/8/29 下午12:01    
*/ 

public class CanJump {
    /*
    * 方法1：从后往前找到能到达最后一个节点的下标
    * 时间复杂度：O(N)，空间复杂度：O(1)
    * */

    public boolean canJump1(int[] nums) {
        int leftMost = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= leftMost) {
                leftMost = i;
            }
        }
        return leftMost == 0;
    }

    /*
    * 方法2：从前往后找能到达的最后的位置
    * 时间复杂度：O(N)，空间复杂度：O(1)
    * */

    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump c = new CanJump();
        System.out.println(c.canJump(new int[]{2,3,1,1,4}));
    }
}
