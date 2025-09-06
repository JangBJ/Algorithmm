class Solution {
    public int maxProfit(int[] prices) {

        var min = Integer.MAX_VALUE;
        var res = 0;

        for(int i=0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i]-min);
        }

        return res;
    }
}