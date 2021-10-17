/**
 * @ClassName:  ReverseWords557
 * @Description: 557. 反转字符串中的单词 III
 * @link: https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @author: liuezhong
 * @date:   2021/10/16 上午11:25
*/

public class ReverseWords557 {
    /*
    * 方法1：
    * 时间复杂度：O(n)，空间复杂度：O(n)
    * */

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (left <= right) {
            int index = left;
            while (index <= right && sArr[index] != ' ') {
                index++;
            }
            reverse(sArr, left, index - 1);
            while (index <= right && sArr[index] == ' ') {
                index++;
            }
            left = index;
        }
        return new String(sArr);
    }

    private void reverse(char[] sArr, int left, int right) {
        while (left < right) {
            char temp = sArr[left];
            sArr[left] = sArr[right];
            sArr[right] = temp;
            left++;
            right--;
        }
    }
}
