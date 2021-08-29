/**   
 * @ClassName:  FindMin
 * @Description: 153. 寻找旋转排序数组中的最小值
 * @link: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @author: liuezhong
 * @date:   2021/8/28 下午4:06    
*/ 

public class FindMin {

    /*
    * 二分法
    * 时间复杂度：O(log(N))，空间复杂度：O(log(N))
    * */

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
