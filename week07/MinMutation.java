import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName:  MinMutation
 * @Description: 433. 最小基因变化
 * @link: https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * @author: liuezhong
 * @date:   2021/9/18 下午10:11
*/

public class MinMutation {
    /*
    * 方法1：BFS
    * 时间复杂度：O(N * C * 4)，空间复杂度：O(N * C * 4),其中 N 为 bank 的长度，C 为列表中单词的长度
    * */

    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)){
            return 0;
        }

        Set<String> bankSet = new HashSet<>();
        for(String b: bank){
            bankSet.add(b);
        }

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)){
                    return level;
                }

                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }

    /*
    * 方法2：双向BFS
    * 时间复杂度：O(N * C * 4)，空间复杂度：O(N * C * 4),其中 N 为 bank 的长度，C 为列表中单词的长度
    * */

    public int minMutation2(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String str : bank) {
            bankSet.add(str);
        }
        if (!bankSet.contains(end)) {
            return -1;
        }
        char[] mode = new char[]{'A','C','G','T'};
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        visited.add(start);
        int step = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> temp = endSet;
                endSet = startSet;
                startSet = temp;
            }
            step++;
            Set<String> levelSet = new HashSet<>();
            for (String cur : startSet) {
                char[] curArray = cur.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char old = curArray[i];
                    for (char ch : mode) {
                        if (ch == old) {
                            continue;
                        }
                        curArray[i] = ch;
                        String next = new String(curArray);
                        if (endSet.contains(next)) {
                            return step;
                        }
                        if (bankSet.contains(next) && !visited.contains(next)){
                            levelSet.add(next);
                            visited.add(next);
                        }
                        curArray[i] = old;
                    }
                }
            }
            startSet = levelSet;
        }
        return -1;
    }
}
