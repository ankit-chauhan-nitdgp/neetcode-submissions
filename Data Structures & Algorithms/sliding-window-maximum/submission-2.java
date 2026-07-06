class Solution {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        // first loop to k > find max
        // either new number is max 
        // removed number is max
            //iterate whole new 
        // in between numbers 
            //  number itself
            int[] ans = new int[nums.length - k + 1];
            Comparator<Integer> comp = (a, b) -> b-a;
            PriorityQueue<Integer> pq = new PriorityQueue(comp);
            // int maxNum = Integer.MIN_VALUE;
            for(int i =0 ; i<k; i++){
                pq.add(nums[i]);
            }

            ans[0] = pq.peek();

            for(int i = k; i < nums.length; i++){
                int newNum = nums[i];
                int oldNum = nums[i - k];
                pq.remove(oldNum);
                pq.add(newNum);

                ans[i-k+1] = pq.peek();
            }

            return ans;
    }
}
