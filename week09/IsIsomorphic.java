import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName:  IsIsomorphic
 * @Description: 205. 同构字符串
 * @link: https://leetcode-cn.com/problems/isomorphic-strings/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:53
*/

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
