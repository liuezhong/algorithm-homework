/**   
 * @ClassName:  MyAtoi
 * @Description: 8. 字符串转换整数 (atoi)
 * @link: https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @author: liuezhong
 * @date:   2021/10/16 下午12:55    
*/ 

public class MyAtoi {
    /*
    * 方法1：
    * 时间复杂度：O(n)，空间复杂度：O(1)
    * */

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int index = 0;
        int sign = 1;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) {
            return 0;
        }
        int firstChar = s.charAt(index);
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }
        while (index < s.length()) {
            if (s.charAt(index) < '0' || s.charAt(index) > '9') {
                break;
            }
            int cur = s.charAt(index) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && cur > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + cur;
            index++;
        }
        return result * sign;
    }
}
