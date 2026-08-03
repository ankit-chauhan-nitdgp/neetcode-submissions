class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val ans = IntArray(k)
        val map = mutableMapOf<Int, Int>()

        // val pq = PriorityQueue<Pair<Int, Int>>(compareBy{it.second})
        
        //bucketSort
        val countArr = Array(nums.size+1){ArrayList<Int>()}
        

        for(num: Int in nums){
            map.put(num, map.getOrDefault(num, 0)+1)
        }

        map.forEach{(key, value) -> 
            // pq.add(Pair(key, value))
            // if(pq.size>k){
            //     pq.poll()
            // }

            // modified bucket sort
            val newList = countArr[value]
            newList.add(key)
            countArr[value] = newList
        }

        var count = k
        var idx = nums.size
        while(count>0 && idx > 0){
            if(countArr[idx] != null){
                for(num: Int in  countArr[idx]){
                    ans[count-1] = num
                    count--
                }
            }
            idx--
        }
        
        // for(i: Int in 0..k-1){
        //     ans[i] = pq.poll().first
        // }

        return ans
    }
}
