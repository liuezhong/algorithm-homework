/**   
 * @ClassName:  ReverseBits
 * @Description: 190. 颠倒二进制位
 * @link: https://leetcode-cn.com/problems/reverse-bits/
 * @author: liuezhong
 * @date:   2021/9/25 下午2:34    
*/ 

public class ReverseBits {
    /*
    * 方法1：
    * 时间复杂度：O(logn)，空间复杂度：O(1),
    * */

    public int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++){
            result |= (n & 1) << (31 - i);
            n >>= 1;
        }
        return result;
    }

    /*
    * 方法1：分治法
    * 时间复杂度：O(1)，空间复杂度：O(1)
    * */

    public int reverseBits(int n) {
        n = (n << 16) | (n >>> 16);
        n = ((n & 0x00ff00ff) << 8) | ((n & 0xff00ff00) >>> 8);
        n = ((n & 0x0f0f0f0f) << 4) | ((n & 0xf0f0f0f0) >>> 4);
        n = ((n & 0x33333333) << 2) | ((n & 0xcccccccc) >>> 2);
        n = ((n & 0x55555555) << 1) | ((n & 0xaaaaaaaa) >>> 1);
        return n;
    }
}
