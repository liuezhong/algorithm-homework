import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:  IsIsomorphic205
 * @Description: 205. 同构字符串
 * @link: isIsomorphic
 * @author: liuezhong
 * @date:   2021/10/16 上午11:48    
*/ 

public class IsIsomorphic205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if ((s2t.containsKey(curS) && s2t.get(curS) != curT) || (t2s .containsKey(curT) && t2s.get(curT) != curS)) {
                return false;
            }
            s2t.put(curS, curT);
            t2s.put(curT, curS);
        }
        return true;
    }
}
