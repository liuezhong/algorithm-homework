/**   
 * @ClassName:  ReverseWords10
 * @Description: 151. 翻转字符串里的单词
 * @link: https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author: liuezhong
 * @date:   2021/10/16 上午10:22    
*/ 

public class ReverseWords10 {
    /*
    * 方法1：使用内置函数
    * 时间复杂度：O(n)，空间复杂度：O(n)
    * */

    public String reverseWords1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] sArr = s.trim().split("\\s+");
        int left = 0;
        int right = sArr.length - 1;
        while (left < right) {
            String temp = sArr[left];
            sArr[left] = sArr[right];
            sArr[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", sArr);
    }

    /*
    * 方法2：不适用内置函数
    * 时间复杂度：O(n)，空间复杂度：O(n)
    * */

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        StringBuilder result = new StringBuilder();
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        while (left <= right) {
            int index = right;
            while (index >= left && s.charAt(index) != ' ') {
                index--;
            }
            for (int i = index + 1; i <= right; i++) {
                result.append(s.charAt(i));
            }
            if (index > left) {
                result.append(' ');
            }
            while (index >= left && s.charAt(index) == ' ') {
                index--;
            }
            right = index;
        }
        return result.toString();
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            q *= nums[i];
            res[i - 1] *= q;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseWords10 r = new ReverseWords10();
//        r.reverseWords("  hello world  ");
        r.productExceptSelf(new int[]{1,2,3,4});
    }
}
