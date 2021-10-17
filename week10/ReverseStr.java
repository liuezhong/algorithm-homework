/**   
 * @ClassName:  ReverseStr
 * @Description: 541. 反转字符串 II
 * @link: https://leetcode-cn.com/problems/reverse-string-ii/
 * @author: liuezhong
 * @date:   2021/10/16 上午10:13    
*/ 

public class ReverseStr {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            reverse(sArr, i, Math.min(i + k - 1, s.length() - 1));
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
