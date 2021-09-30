import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**   
 * @ClassName:  IsAnagram
 * @Description: 242. 有效的字母异位词
 * @link: https://leetcode-cn.com/problems/valid-anagram/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:43    
*/ 

public class IsAnagram09 {
//    方法1：map
    public boolean isAnagram1(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) == 0 ) {
                map.remove(ch);
            }
        }
        return true;
    }
//    方法2：排序
    public boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return new String(sArr).equals(new String(tArr));
    }
}
