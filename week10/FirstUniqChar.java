import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:  FirstUniqChar
 * @Description: 387. 字符串中的第一个唯一字符
 * @link: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @author: liuezhong
 * @date:   2021/10/16 上午10:08    
*/ 

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
