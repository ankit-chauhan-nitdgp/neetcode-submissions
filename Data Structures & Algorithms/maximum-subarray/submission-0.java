class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for(int ws = 1; ws <= n; ws++){
            int temp = 0;
            for(int j = 0; j<ws; j++){
                temp += nums[j];
            }
            ans = Math.max(ans, temp);
            int curr = ws;
            while(curr < n){
                temp = temp+nums[curr]-nums[curr - ws];
                ans = Math.max(ans, temp);
                curr++;
            }
        }

        return ans;
    }
}
