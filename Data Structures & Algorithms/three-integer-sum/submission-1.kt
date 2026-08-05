class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        nums.sort()
        for(i:Int in 0..nums.size-3){

            //skip first duplicate
            if(i>0 && nums[i-1]==nums[i]) continue

            val req = -1*nums[i]
            var left = i+1
            var right = nums.size-1

            while(left<right){

                
                val leftNum = nums[left]
                val rtNum = nums[right]
                val sum = leftNum + rtNum
                if(sum == req){
                    answer.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--
                        // Skip duplicate left values
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++
                        }

                        // Skip duplicate right values
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--
                        }
                }
                else if(sum < req){
                    left++
                }else{
                    right--
                }
            }
        }

        return answer
    }
}
