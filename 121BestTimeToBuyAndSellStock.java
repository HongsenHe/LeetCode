/*
 * Say you have an array for which the ith element is the price 
 * of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm
 * to find the maximum profit.
 */

/*
 * for all prices, if current < min, min = current
 * compare current - min and max profit, save bigger
 */

/*
 * for all prices, if current < min, min = current
 * compare current - min and max profit, save bigger
 */

public class Solution {
    // public int maxProfit(int[] prices) {
    //     if (prices == null || prices.length == 0) {
    //         return 0;
    //     }
        
    //     int min = Integer.MAX_VALUE;
    //     int profit = 0;
    //     for (int i : prices) {
    //         min = i < min ? i : min;
    //         profit = (i - min) > profit ? i - min : profit;
    //     }
        
    //     return profit;
    // }
    
    /*
    用“局部最优和全局最优解法”。思路是维护两个变量，一个是到目前为止最好的交易，
    另一个是在当前一天卖出的最佳交易（也就是局部最优）。
    */
    // solution 2
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int local = 0;
        int global = 0;
        
        for(int i=0;i<prices.length-1;i++) {
            local = Math.max(local+prices[i+1]-prices[i],0);
            global = Math.max(local, global);
        }
    
        return global;
    }
    
}