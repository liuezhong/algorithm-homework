import java.util.*;

/**
 * @ClassName:  FindAnagrams
 * @Description: 438. 找到字符串中所有字母异位词
 * @link: https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @author: liuezhong
 * @date:   2021/10/16 下午2:22    
*/ 

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pCnt = new HashMap<>();
        Map<Character, Integer> sCnt = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pCnt.put(ch, pCnt.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char curRight = s.charAt(right);
            sCnt.put(curRight, sCnt.getOrDefault(curRight, 0) + 1);
            while (sCnt.get(curRight) > pCnt.getOrDefault(curRight, 0)) {
                char curLeft = s.charAt(left);
                sCnt.put(curLeft, sCnt.getOrDefault(curLeft, 0) - 1);
                left++;
            }
            if (right - left + 1 == p.length()) {
                result.add(left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAnagrams f = new FindAnagrams();
        f.findAnagrams("cbaebabacd", "abc");
    }
}
