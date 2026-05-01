class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lm = 0;
        int rm = n-1;
        int ans = 0;

        for(int i = n-1; i >= 1; i--){
            if(height[i] > height[rm]){
                rm = i;
            }
        }

        for(int i = 1; i <= n-1; i++){
            if(height[lm] < height[i-1]){
                lm = i-1;
            }

            if(rm == i){
                lm = i;
                rm = n-1;
                for(int j = n-1; j >i ; j--){
                    if(height[j] > height[rm]){
                        rm = j;
                    }
                }
            }

            if(height[rm] > height[i] && height[lm]> height[i]){
                ans += Math.min(height[rm], height[lm]) - height[i];
            }
        }

        return ans;
    }
}
