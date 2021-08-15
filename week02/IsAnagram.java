import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName:  IsAnagram
 * @Description:  242. 有效的字母异位词
 * @link:  https://leetcode-cn.com/problems/valid-anagram/
 * @author: liuezhong
 * @date:   2021/8/13 上午10:22
 */

public class IsAnagram {

    /*
    * 方法1：map
    * 用map统计源字符出现的次数，然后与目标字符进行比较，有相同字符则相应字符个数减1，当有字符个数小于0时，则不是字母异位词
    * 时间复杂度：o(n),空间复杂度：o(n);
    * */

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            int num = map.get(t.charAt(i));
            if (num < 0) {
                return false;
            }
        }
        return true;
    }

    /*
    * 方法2：排序
    * 先对两字符串进行排序再比较
    * 时间复杂度：o(nlogn),空间复杂度，o(n)，因为字符不可变，需要额外的 O(n) 的空间来拷贝字符串
    * */

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        if (Arrays.equals(sArr, tArr)) {
            return true;
        }
        return false;
    }

    /*
    * 方法3:数组
    * 与方法1类似，只是辅助数组来解决
    * 时间复杂度：o(n),空间复杂度：o(s),s为字符集的长度：26
    * */

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if (arr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram i = new IsAnagram();
        System.out.println(i.isAnagram("anagram", "nagaram"));
    }
}
