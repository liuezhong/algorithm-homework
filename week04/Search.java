/**   
 * @ClassName:  Search
 * @Description: 33. 搜索旋转排序数组
 * @link: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @author: liuezhong
 * @date:   2021/8/28 下午3:50    
*/ 

public class Search {
    /*
    * 方法1：直接二分查找
    * 时间复杂度：O(log(n))，空间复杂度：O(1)
    * */

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[0]){
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /*
    * 方法2：先找出旋转位置，再进行二分查找
    * 时间复杂度：O(log(n))，空间复杂度：O(1)
    * */

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
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
        int minLoc = left;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int originMid = (mid + minLoc) % nums.length;
            if (target == nums[originMid]) {
                return originMid;
            }
            if (target < nums[originMid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
