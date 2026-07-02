class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void helper(int[] nums, List<Integer> list, int start){
        if(start == nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
  
            list.add(nums[start]);
            helper(nums, list, start+1);
            list.remove(list.size()-1);
            helper(nums, list, start+1);
       
        return;
    }
}
