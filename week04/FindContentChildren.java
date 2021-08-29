import java.util.Arrays;

/**
 * @ClassName:  FindContentChildren
 * @Description: 455. 分发饼干
 * @link: https://leetcode-cn.com/problems/assign-cookies/description/
 * @author: liuezhong
 * @date:   2021/8/29 上午10:57    
*/ 

public class FindContentChildren {
    /*
    *
    * 时间复杂度：O(N)，空间复杂度：O(1)
    * */

    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return count;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}
