import java.util.Stack;

/**
 * @ClassName:  LongestValidParentheses  
 * @Description: 32. 最长有效括号
 * @link: https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author: liuezhong
 * @date:   2021/9/12 下午7:34    
*/ 

public class LongestValidParentheses {
    /*
    * 方法1：
    * 时间复杂度：O(n)，空间复杂度：O(n)
    * */

    public int longestValidParentheses1(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

    /*
    * 方法2：动态规划
    * 时间复杂度：O(n)，空间复杂度：O(n)
    * */

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] + 2 : 2);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
