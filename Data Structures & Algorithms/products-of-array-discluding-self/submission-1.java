class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // int[] ans = new int[n];
        int[] prefixProduct = new int[n];
        // int[] suffixProduct = new int[n+1];
        // prefixProduct[0] = 1;
        // suffixProduct[n-1] = 1;
        

        int temp = 1;
        for(int i = 0; i<n; i++){
                prefixProduct[i] = temp;
                temp = prefixProduct[i]*nums[i];
        }
        temp = 1;

        for(int i = n-1; i>=0 ; i--){
                prefixProduct[i] = prefixProduct[i]*temp;
                temp = temp*nums[i];
        }

        // for(int i = 0; i<n; i++){
        //     ans[i] = prefixProduct[i]*suffixProduct[i];
        // }

        return prefixProduct;
    }
}  
