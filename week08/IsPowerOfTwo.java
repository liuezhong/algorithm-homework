/**
 * @ClassName:  IsPowerOfTwo
 * @Description: 231. 2 的幂
 * @link: https://leetcode-cn.com/problems/power-of-two/
 * @author: liuezhong
 * @date:   2021/9/25 下午2:27
*/

public class IsPowerOfTwo {
    /*
    * 方法1：
    * 时间复杂度：O(1)，空间复杂度：O(1)
    * */

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    /*
    * 方法2：
    * 时间复杂度：O(1)，空间复杂度：O(1)
    * */

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }
}

