/**   
 * @ClassName:  ReverseOnlyLetters
 * @Description: 917. 仅仅反转字母
 * @link: https://leetcode-cn.com/problems/reverse-only-letters/
 * @author: liuezhong
 * @date:   2021/10/16 上午11:40    
*/ 

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int left = 0;
        int right = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (left < right) {
            while (left < right && !Character.isLetter(sArr[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(sArr[right])) {
                right--;
            }
            char temp = sArr[left];
            sArr[left] = sArr[right];
            sArr[right] = temp;
            left++;
            right--;
        }
        return new String(sArr);
    }
}
