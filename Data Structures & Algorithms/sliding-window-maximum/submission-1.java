class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int max =nums[0];
        for(int i = 0; i < k; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        ans[0] = max;

        for(int i = k; i<nums.length; i++){
            int newNum = nums[i];
            int oldNum = nums[i-k];

            if(max == oldNum){
                if(newNum >= oldNum){
                    max = newNum;
                }else{
                    max = newNum;
                    for(int j = i-k+1; j<=i; j++){
                        if(nums[j] > max){
                            max = nums[j];
                        }
                    }
                }
            }else{
                max = Math.max(newNum, max);
            }
            
            ans[i-k+1] = max;
        }

        return ans;
    }
}
