import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 1. 两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> targetMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (targetMap.containsKey(nums[i])) {
                return new int[]{i, targetMap.get(nums[i])};
            }
            targetMap.put(target - nums[i], i);
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            targetMap.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (targetMap.containsKey(nums[i]) && targetMap.get(nums[i]) != i) {
                return new int[]{i, targetMap.get(nums[i])};
            }
        }
        return new int[0];
    }

}
