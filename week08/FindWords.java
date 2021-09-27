import java.util.*;

/**
 * @ClassName:  FindWords
 * @Description: 212. 单词搜索 II
 * @link: https://leetcode-cn.com/problems/word-search-ii/
 * @author: liuezhong
 * @date:   2021/9/25 下午5:12    
*/ 

public class FindWords {
    private int[] dirX = new int[]{0, 1, 0, -1};
    private int[] dirY = new int[]{1, 0, -1, 0};
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) {
            return Collections.emptyList();
        }
        Set<String> result = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,result, trie, i, j);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, Set<String> result, Trie trie, int x, int y) {
        if (!trie.children.containsKey(board[x][y])) {
            return;
        }
        char ch = board[x][y];
        trie = trie.children.get(ch);
        if (!"".equals(trie.word)) {
            result.add(trie.word);
        }
        board[x][y] = '#';
        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length) {
                dfs(board, result, trie, nextX, nextY);
            }
        }
        board[x][y] = ch;
    }

    class Trie{
        Map<Character, Trie> children;
        String word;
        public Trie() {
            this.children = new HashMap<>();
            this.word = "";
        }
        public void insert(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                if (node.children.get(ch) == null) {
                    node.children.put(ch, new Trie());
                }
                node = node.children.get(ch);
            }
            node.word = word;
        }

    }
}
