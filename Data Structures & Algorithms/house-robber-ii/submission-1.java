class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        
        if(n == 1){
            return nums[0];
        }else if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] temp = new int[n-1];

        Arrays.fill(dp,-1);
        for(int i = 0; i<n-1;i++){
            temp[i] = nums[i];
        }
        int left = helper(0, temp);

        Arrays.fill(dp,-1);
        for(int i = 1; i<n;i++){
            temp[i-1] = nums[i];
        }
        int right = helper(0, temp);

        return Math.max(left, right);
    }

    private int helper(int i, int[] nums){
        if(i >= nums.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        return dp[i] = Math.max(nums[i]+helper(i+2, nums), helper(i+1, nums));
    }
}
