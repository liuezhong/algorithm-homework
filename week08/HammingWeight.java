/**   
 * @ClassName:  HammingWeight
 * @Description: 191. 位1的个数
 * @link: https://leetcode-cn.com/problems/number-of-1-bits/
 * @author: liuezhong
 * @date:   2021/9/25 下午2:21    
*/ 

public class HammingWeight {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n &= n - 1;
            result++;
        }
        return result;
    }
}
