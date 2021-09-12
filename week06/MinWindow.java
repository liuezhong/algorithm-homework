import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:  MinWindow
 * @Description: 76. 最小覆盖子串
 * @link: https://leetcode-cn.com/problems/minimum-window-substring/
 * @author: liuezhong
 * @date:   2021/9/11 下午4:42
*/

public class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        for (char ch : t.toCharArray()) {
            needMap.put(ch, needMap.getOrDefault(ch, 0) + 1);
        }
        while(right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (needMap.containsKey(ch)) {
                windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
                if (windowMap.get(ch).equals(needMap.get(ch))) {
                    valid++;
                }
            }
            while(valid == needMap.size()) {
                if (right - left < len) {
                    len = right -left;
                    start = left;
                }
                char c = s.charAt(left);
                left++;
                if (windowMap.containsKey(c)) {
                    if(windowMap.get(c).equals(needMap.get(c))) {
                        valid--;
                    }
                    windowMap.put(c, windowMap.getOrDefault(c, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
