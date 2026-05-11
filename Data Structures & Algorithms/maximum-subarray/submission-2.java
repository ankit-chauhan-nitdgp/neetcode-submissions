class Solution {
    public int maxSubArray(int[] nums) {
        // int n = nums.length;
        // int ans = Integer.MIN_VALUE;
       

        // //time = O(n^2), space = O(1);
        // for(int ws = 1; ws <= n; ws++){
        //     int temp = 0;
        //     for(int i = 0; i<ws; i++){
        //         temp += nums[i];
        //     }
        //     ans = Math.max(ans, temp);
        //     int curr = ws;
        //     while(curr < n){
        //         temp = temp+nums[curr]-nums[curr - ws];
        //         ans = Math.max(ans, temp);
        //         curr++;
        //     }
        // }
        //

        //kadane algo
        int n = nums.length;
        int curr_max = nums[0];
        int global_max = nums[0];
        for(int i = 1; i<n;i++){
            curr_max = Math.max(nums[i], curr_max+nums[i]);
            global_max = Math.max(curr_max, global_max);
        }

        return global_max;
    }
}
