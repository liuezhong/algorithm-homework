import java.util.*;

/**   
 * @ClassName:  GroupAnagrams
 * @Description:  49. 字母异位词分组
 * @link: https://leetcode-cn.com/problems/group-anagrams/
 * @author: liuezhong
 * @date:   2021/8/13 上午11:21    
*/ 

public class GroupAnagrams {

    /*
    * 方法1：排序
    * 先对字符串进行排序辅助map，排序后的字符串作为键，有相同排序后字符串的排序前字符串形成的列表作为值
    * */

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /*
    * 方法2：数组
    * 先通过数组统计出字符出现次数，然后辅助map，用字符+出现次数的组合作为键，源字符串列表作为值
    * */

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            StringBuilder key = new StringBuilder();
            int[] arr = new int[26];
            for (char ch : str.toCharArray()) {
                arr[ch - 'a']++;
            }
            for (int i = 0; i < arr.length; i++) {
                key.append((char)(i + 'a'));
                key.append(arr[i]);
            }
            List<String> list = map.getOrDefault(key.toString(), new ArrayList<>());
            list.add(str);
            map.put(key.toString(), list);
        }
        return new ArrayList<>(map.values());
    }

    /*
    * 方法3：map
    * 与方法二类似，只是辅助map统计字符出现次数，然后辅助map，用字符+出现次数的组合作为键，源字符串列表作为值
    * */

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> charMap = new TreeMap<>();
            for (char ch : str.toCharArray()) {
                charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
            }

            StringBuilder uniqueKey = new StringBuilder();
            for (char key : charMap.keySet()) {
                uniqueKey.append(key);
                uniqueKey.append(charMap.get(key));
            }
            List<String> list = map.getOrDefault(uniqueKey.toString(), new ArrayList<>());
            list.add(str);
            map.put(uniqueKey.toString(), list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams.groupAnagrams(strings);
    }
}
