import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName:  Permute
 * @Description: 46. 全排列
 * @link: https://leetcode-cn.com/problems/permutations/
 * @author: liuezhong
 * @date:   2021/8/21 下午3:07    
*/ 

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        myPermute(result, new ArrayList<>(), 0, visited, nums);
        return result;
    }

    private void myPermute(List<List<Integer>> result, List<Integer> midList, int row, int[] visited, int[] nums) {
        if (row == nums.length) {
            result.add(new ArrayList<>(midList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            midList.add(nums[i]);
            visited[i] = 1;
            myPermute(result, midList, row + 1, visited, nums);
            midList.remove(midList.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        p.permute(new int[]{1,2,3});
    }
}
