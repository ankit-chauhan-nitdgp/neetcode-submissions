class Solution {
    fun findDuplicate(nums: IntArray): Int {
        nums.sort()
        for(i: Int in 1..nums.size-1){
            if(nums[i] == nums[i-1]){
                return nums[i]
            }
        }

        return nums[0]
    }
}
