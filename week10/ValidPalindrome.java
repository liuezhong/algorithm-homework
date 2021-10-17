/**   
 * @ClassName:  ValidPalindrome
 * @Description: 680. 验证回文字符串 Ⅱ
 * @link: https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @author: liuezhong
 * @date:   2021/10/16 下午12:24    
*/ 

public class ValidPalindrome {
    /*
    * 方法1：
    * 时间复杂度：O(n)，空间复杂度：O(1)
    * */

    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValidPalindrome(s, left + 1, right) || isValidPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValidPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
