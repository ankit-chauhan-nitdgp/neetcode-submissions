class Solution {
    var ans:Int = Integer.MAX_VALUE
    fun findMin(nums: IntArray): Int {

        minHelper(nums, 0, nums.size-1)
        return ans
    }

    fun minHelper(nums: IntArray, l: Int, r: Int){
        if(l>r){
            return
        }

        val mid = l+(r-l)/2
        if(nums[l]<=nums[mid] && nums[mid]<= nums[r]){
            ans = min(ans, nums[l])
        }else if(nums[l]<=nums[mid]){
            ans = min(ans, nums[l])
            minHelper(nums, mid+1, r)
        }else {
            ans = min(ans, nums[mid])
            minHelper(nums, l, mid-1)
        }

        return

    }
}
