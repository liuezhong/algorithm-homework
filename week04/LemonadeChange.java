/**   
 * @ClassName:  LemonadeChange
 * @Description: 860. 柠檬水找零
 * @link: https://leetcode-cn.com/problems/lemonade-change/description/
 * @author: liuezhong
 * @date:   2021/8/28 上午10:04    
*/ 

public class LemonadeChange {
    /*
    *
    * 时间复杂度：O(N)，空间复杂度：O(1),其中N为bills的长度
    * */

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }else if (bills[i] == 10) {
                if (five <= 0) {
                    return false;
                }
                ten++;
                five--;
            } else if (bills[i] == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
