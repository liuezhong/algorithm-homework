import java.util.LinkedList;
import java.util.Deque;

public class Trap {

    /**
     * 42. 接雨水
     */

//    方法1：单调栈

    public int trap(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int result = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int curWidth = i - stack.peek() - 1;
                int curHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                result += curHeight * curWidth;
            }
            stack.push(i);
        }
        return result;

    }

    //  方法2：动态规划

    public int trap2(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int n = height.length;
        int result = 0;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];



        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Trap t = new Trap();
        t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
