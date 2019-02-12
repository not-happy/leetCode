package array.q2;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 */
class Solution {
    public int maxProfit(int[] prices) {
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]){
                prices[index++] = prices[i] - prices[i - 1];
            }
        }

        if(index == 0){
            return 0;
        }

        if(index == 1){
            return prices[0];
        }

        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += prices[i];
        }

        return sum;
    }
}