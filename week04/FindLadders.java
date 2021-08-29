import java.util.*;

/**
 * @ClassName:  FindLadders
 * @Description: 126. 单词接龙 II
 * @link: https://leetcode-cn.com/problems/word-ladder-ii/description/
 * @author: liuezhong
 * @date:   2021/8/28 下午5:05
*/

public class FindLadders {
    /*
    * BFS遍历得出最短路径，再用DFS搜索输出转换列表
    *
    * */

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (beginWord.equals(endWord) || !wordSet.contains(endWord)) {
            return Collections.emptyList();
        }
        List<List<String>> result = new ArrayList<>();
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Map<String, List<String>> from = new HashMap<>();
        int step = 0;
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size-- > 0) {
                String cur = queue.remove();
                char[] curArray = cur.toCharArray();
                for (int i = 0; i < beginWord.length(); i++) {
                    char old = curArray[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) {
                            continue;
                        }
                        curArray[i] = ch;
                        String next = new String(curArray);
                        if (steps.containsKey(next) && steps.get(next) == step) {
                            from.get(next).add(cur);
                        }
                        if (!wordSet.contains(next)) {
                            continue;
                        }
                        wordSet.remove(next);

                        from.putIfAbsent(next, new ArrayList<>());
                        from.get(next).add(cur);

                        queue.add(next);

                        steps.put(next, step);
                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }
                    curArray[i] = old;
                }
            }
            if (found) {
                break;
            }
        }
        if (found) {
            Deque<String> path = new LinkedList<>();
            path.add(endWord);
            dfs(result, path , from, beginWord, endWord);
        }
        return result;
    }

    private void dfs(List<List<String>> result,Deque<String> path, Map<String, List<String>> from, String beginWord, String curWord) {
        if (curWord.equals(beginWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (String word : from.get(curWord)) {
            path.addFirst(word);
            dfs(result, path, from, beginWord, word);
            path.removeFirst();
        }
    }


    public static void main(String[] args) {
        FindLadders l = new FindLadders();
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        l.findLadders("hit","cog", list);
    }
}
