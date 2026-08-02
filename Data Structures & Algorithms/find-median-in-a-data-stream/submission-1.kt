class MedianFinder {

    val pq = PriorityQueue<Int>()
    var count = 0
    val tempArr = ArrayList<Int>()
    val newArr = ArrayList<Int>()
    fun addNum(num: Int) {
        // pq.offer(num)
        // count+=1
        newArr.add(num)
        newArr.sort()
    }

    fun findMedian(): Double {
        // if(count == 0){
        //     return 0.0
        // }
        // val n = count/2
        // for(n: Int in 0..n){
        //     val temp = pq.poll()
        //     tempArr.add(temp)
        // }
        // var median: Double = (tempArr[tempArr.size-1]).toDouble()
        // if(count%2 == 0){
        //     median = (median+tempArr[tempArr.size-2])/2.0
        // }
        
        // for(num: Int in tempArr){
        //     pq.add(num)
        // }
        // tempArr.clear()
        val n = newArr.size
        if(n == 0){
            return 0.0
        }
        val idx = n/2
        var median: Double = (newArr[idx]).toDouble()
        if(n%2 == 0){
            median = (median+newArr[idx-1])/2.0
        }
        return median
    }
}
