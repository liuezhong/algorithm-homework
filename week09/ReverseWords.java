import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @ClassName:  ReverseWords
 * @Description: 151. 翻转字符串里的单词
 * @link: https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:54
*/

public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
