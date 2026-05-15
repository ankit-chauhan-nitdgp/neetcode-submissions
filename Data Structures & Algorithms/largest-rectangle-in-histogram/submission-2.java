class Solution {
    Stack<Integer> stk;
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int left = 0;
        int right;
        int ans = heights[0];

        stk = new Stack<>();

        // int[] prevSmaller = new int[n];
        // prevSmaller = prevSmaller(heights);
        int[] nextSmaller = new int[n];
        nextSmaller = nextSmaller(heights);
        int ps = -1;

        stk.clear();
        for(int i=0;i<n;i++){
            // brute force
           /* int self = heights[i];
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
            ans = Math.max(ans, (right-left + 1)*self);*/
            
            // previous smaller calc. 
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }

            if(stk.isEmpty()){
                ps = -1;
            }else{
                ps = stk.peek();
            }

            stk.push(i);
            // prev smaller calc. end


            ans = Math.max(ans, (nextSmaller[i]- ps -1)*heights[i]);
        }

        return ans;
    }

    private int[] nextSmaller(int[] arr){
        int n= arr.length;
        int[] temp = new int[n];

        
        for(int i = n-1; i>=0; i--){

            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                stk.pop();
            }

            if(stk.isEmpty()){
                temp[i] = n;
            }else{
                temp[i] = stk.peek();
            }

            stk.push(i);
        }

        return temp;
        
    }
}
