class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>() //max heap

        for(num: Int in nums){

            minHeap.add(num)

            if(minHeap.size > k){
                minHeap.poll()
            } 
        }

        return minHeap.poll()
    }
}
