class Solution {
    /* Input: prices = [10,1,5,6,7,1]
    Output: 6 
    Exp: buy for 1 (day 2) sell for 7 (day 5); 
    */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, prices[i]);
            ans = Math.max(prices[i]-min, ans);
        }

        return ans;
    }
}
