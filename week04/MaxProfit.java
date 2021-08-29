/**   
 * @ClassName:  MaxProfit
 * @Description: 122. 买卖股票的最佳时机 II
 * @link: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * @author: liuezhong
 * @date:   2021/8/29 上午10:51    
*/ 

public class MaxProfit {
    /*
    * 只要后一天的股价大于前一天，就可以卖了
    * 时间复杂度：O(n)，空间复杂度：O(1)
    * */

    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length == 0) {
            return profit;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
