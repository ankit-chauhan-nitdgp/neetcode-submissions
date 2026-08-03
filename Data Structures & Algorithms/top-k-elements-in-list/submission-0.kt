class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val ans = IntArray(k)
        val map = mutableMapOf<Int, Int>()
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy{it.second})
        
        for(num: Int in nums){
            map.put(num, map.getOrDefault(num, 0)+1)
        }

        map.forEach{(key, value) -> 
            pq.add(Pair(key, value))
            if(pq.size>k){
                pq.poll()
            }
        }
        
        for(i: Int in 0..k-1){
            ans[i] = pq.poll().first
        }

        return ans
    }
}
