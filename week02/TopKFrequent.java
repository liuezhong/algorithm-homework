import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName:  TopKFrequent
 * @Description:  前 K 个高频元素
 * @link: https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author: liuezhong
*/

public class TopKFrequent {

// 基于小根堆，先用map统计数组中元素出现频率，再将前K个高频元素放入小根堆中，过程中不断将频率最小的元素替换出来

    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(new int[]{map.get(key), key});
            } else if (queue.peek()[0] < map.get(key)){
                queue.remove();
                queue.add(new int[]{map.get(key), key});
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.remove()[1];
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
        t.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
    }
}
