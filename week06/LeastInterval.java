import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:  LeastInterval
 * @Description: 621. 任务调度器
 * @link: https://leetcode-cn.com/problems/task-scheduler/
 * @author: liuezhong
 * @date:   2021/9/12 下午7:14    
*/ 

public class LeastInterval {
    /*
    *
    * 时间复杂度：O(n)，空间复杂度：O(n)
    * */

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        Map<Character, Integer> taskMap = new HashMap<>();
        int maxCount = 0;
        int maxExec = 0;
        for (char task : tasks) {
            int num = taskMap.getOrDefault(task, 0) + 1;
            taskMap.put(task, num);
            maxExec = Math.max(maxExec, num);
        }

        for (Character key : taskMap.keySet()) {
            if (taskMap.get(key).equals(maxExec)) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (maxExec - 1) * (n + 1)  + maxCount);
    }
}
