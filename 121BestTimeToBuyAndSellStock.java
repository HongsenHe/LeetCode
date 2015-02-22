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

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            min = i < min ? i : min;
            profit = (i - min) > profit ? i - min : profit;
        }
        
        return profit;
    }
}