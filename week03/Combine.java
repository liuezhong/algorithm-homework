import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName:  Combine
 * @Description: 77. 组合
 * @link: https://leetcode-cn.com/problems/combinations/
 * @author: liuezhong
 * @date:   2021/8/21 下午2:09
*/

public class Combine {

    /*
    * 方法1：递归
    * */

    public List<List<Integer>> combine1(int n, int k) {
        if (n == 0 || n < k || k == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        myCombine(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void myCombine(List<List<Integer>> result, List<Integer> midList, int n, int k, int begin) {
        if (midList.size() == k) {
            result.add(new ArrayList<>(midList));
            return;
        }
        for (int i = begin; i <= n - (k - midList.size()) + 1; i++) {
            midList.add(i);
            myCombine(result, midList, n, k, i + 1);
            midList.remove(midList.size() - 1);
        }
    }

    /*
    * 方法2：
    * 每个数字都有选与不选两种可能
    * */

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || n < k || k == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> midList, int n, int k, int begin) {
        if (k == 0) {
            result.add(new ArrayList<>(midList));
            return;
        }
        if (begin > n - k + 1) {
            return;
        }
        dfs(result, midList, n, k,begin + 1);

        midList.add(begin);
        dfs(result, midList, n, k - 1, begin + 1);
        midList.remove(midList.size() - 1);
    }
}
