class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int left;
        int right;
        int ans = heights[0];

        for(int i=0;i<n;i++){
            int self = heights[i];
            left = i;
            right = i;
            // i-1 to 0 -> immediate higher
            for(int j = i-1; j>=0; j--){
                if(heights[j] < self){
                    break;
                }
                left = j;
            }

            //i+1 to n -> immediate higher
            for(int j = i+1; j<n; j++){
                if(heights[j] < self){
                    break;
                }
                right = j;
            }

            int rect = Math.max((right-left + 1)*self, self);
            ans = Math.max(ans, rect);

        }

        return ans;
    }
}
