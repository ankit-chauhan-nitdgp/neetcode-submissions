class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        makeCombinationList(nums, target, 0, new ArrayList<Integer>());
        return ans;
    }

    private void makeCombinationList(int[] nums, int target, int idx, List<Integer> list){

        if(idx == nums.length){
            return;
        }

        if(target == 0){
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        if(nums[idx] <= target){
            //selected
                list.add(nums[idx]);
                makeCombinationList(nums, target- nums[idx], idx, list);
                list.remove(list.size()-1);
            // not selected
                makeCombinationList(nums, target, idx+1, list);
        }else{
            makeCombinationList(nums, target, idx+1, list);
        }

        return;
    }

}
