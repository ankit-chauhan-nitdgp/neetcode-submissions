class Solution {
    fun trap(height: IntArray): Int {

        if(height.size<=2){
            return 0
        }
        
        var ans = 0
        val stack = ArrayDeque<Int>()
        var left = height[0]

         for(i: Int in height.size-1 downTo 0){
            if(stack.isEmpty() || height[stack.last] <= height[i]){
                stack.add(i)
            }
         }

        for(i: Int in 0..height.size-1){
            if(i>0){
                left = max(left, height[i-1])
            }

            if( stack.isNotEmpty() && i == stack.last){
                stack.removeLast()
            }

            if(stack.isNotEmpty() && height[i]<left && height[i]<height[stack.last]){
                ans = ans + min(left, height[stack.last]) - height[i]
            }
        }

        return ans
    }
}
