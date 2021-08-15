import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:  TwoSum2
 * @Description:  1. 两数之和
 * @link: https://leetcode-cn.com/problems/two-sum/description/
 * @author: liuezhong
 * @date:   2021/8/14 下午6:54    
*/ 

public class TwoSum2 {

    /*
    * 将target-num[i]放入map,再遍历数组num[i]是否存在于map中，如果存在则为目标值
    * */

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}
