class Solution {
    fun search(nums: IntArray, target: Int): Int {
      
        var st = 0;
        var end = nums.size-1;

        while(st <= end){
            val mid = st + (end-st)/2

            if(target == nums[mid]){
                return mid
            }

            if(nums[st] <= nums[mid]){ // left sorted
                if(nums[st] <= target && target <= nums[mid]){ // inside left sorted
                    end = mid-1
                }else{// inside right unsorted
                    st = mid+1 
                }
            }else{ //right sorted
                if(nums[mid] <= target && target <= nums[end]){//inside right sorted
                    st = mid+1
                }else{//inside left unsorted
                    end = mid-1
                }
            }
        }

        return -1
    }

}
