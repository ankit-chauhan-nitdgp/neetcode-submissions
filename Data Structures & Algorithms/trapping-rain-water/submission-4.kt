class Solution {
    fun trap(height: IntArray): Int {

        val rightMaxStack = ArrayDeque<Int>()

        for(i: Int in height.size-1 downTo 1){
            if(rightMaxStack.lastOrNull() == null){
                rightMaxStack.addLast(i)
            }else if(height[rightMaxStack.last()] < height[i]){
                rightMaxStack.addLast(i)
            }
        }

        var lMax = 0
        var ans = 0

        for(i: Int in 1..height.size-2){
            lMax = max(height[i-1], lMax)

            if(i == rightMaxStack.last()){
                rightMaxStack.removeLast()
            }

            val rMax = height[rightMaxStack.last()]

            // println("val: ${height[i]} lMax: ${lMax} rMax: ${rMax}")

            val minVal = min(lMax, rMax)
            if(height[i] < minVal){
                ans = ans+(minVal - height[i])
            }
        }

        return ans

    }
}
