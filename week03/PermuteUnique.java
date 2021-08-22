import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName:  PermuteUnique
 * @Description: 47. 全排列 II
 * @link: https://leetcode-cn.com/problems/permutations-ii/
 * @author: liuezhong
 * @date:   2021/8/21 下午3:36    
*/ 

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        myPermuteUnique(result, new ArrayList<>(), nums, 0, visited);
        return result;
    }

    private void myPermuteUnique(List<List<Integer>> result, List<Integer> midList, int[] nums, int depth, int[] visited) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(midList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == 0)) {
                continue;
            }
            midList.add(nums[i]);
            visited[i] = 1;
            myPermuteUnique(result, midList, nums, depth + 1, visited);
            midList.remove(midList.size() - 1);
            visited[i] = 0;
        }
    }
}
