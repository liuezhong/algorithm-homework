import java.util.*;

/**
 * @ClassName:  LadderLength
 * @Description: 127. 单词接龙
 * @link: https://leetcode-cn.com/problems/word-ladder/
 * @author: liuezhong
 * @date:   2021/8/28 上午11:19    
*/ 

public class LadderLength {
    /*
    * 方法1：BFS
    * 时间复杂度：O(N * wordLen * 26)，空间复杂度：O(N)
    * */

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                String cur = queue.remove();
                if (cur.equals(endWord)) {
                    return level;
                }
                char[] curArray = cur.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char old = curArray[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) {
                            continue;
                        }
                        curArray[i] = ch;
                        String next = new String(curArray);
                        if (!visited.contains(next) && wordSet.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                    curArray[i] = old;
                }
            }
        }
        return 0;
    }

    /*
    * 方法2：双向BFS
    * 时间复杂度：O(N * wordLen * 26)，空间复杂度：O(N)
    * */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (beginWord.equals(endWord) || !wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            level++;
            Set<String> levelSet = new HashSet<>();
            for (String cur : beginSet){
                char[] curArray = cur.toCharArray();
                for (int i = 0; i < cur.length(); i++) {
                    char old = curArray[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) {
                            continue;
                        }
                        curArray[i] = ch;
                        String next = new String(curArray);
                        if (endSet.contains(next)) {
                            return level;
                        }
                        if (!visited.contains(next) && wordSet.contains(next)) {
                            levelSet.add(next);
                            visited.add(next);
                        }
                    }
                    curArray[i] = old;
                }
            }
            beginSet = levelSet;
        }
        return 0;
    }

    public static void main(String[] args) {
        LadderLength l = new LadderLength();
        List<String> list = Arrays.asList("hot","dot","dog","lot","log");
        l.ladderLength("hit","cog", list);

    }
}
