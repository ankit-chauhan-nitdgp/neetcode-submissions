class Solution {
  
      fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

        val preList: HashMap<Int, MutableList<Int>> = HashMap<Int, MutableList<Int>>()
        val stack = ArrayDeque<Int>()

        val vis = BooleanArray(numCourses)
        val recPath = BooleanArray(numCourses)

        for(item: IntArray in prerequisites){
            val oldList: MutableList<Int> = preList.getOrDefault(item[1], mutableListOf<Int>())
            oldList.add(item[0])
            preList.put(item[1],oldList)
        }

        for(i: Int in 0..numCourses-1){
            if(findHelper(i, vis,recPath,stack, preList)){
                return IntArray(0)
            }
        }

        val ans: MutableList<Int> = mutableListOf()
        while(stack.isNotEmpty()){
            ans.add(stack.removeLast())
        }

        return ans.toIntArray()
    }

    fun findHelper(curr: Int, vis: BooleanArray, recPath: BooleanArray ,stack: ArrayDeque<Int>, pre: HashMap<Int,MutableList<Int>>): Boolean{
        vis[curr] = true
        recPath[curr] = true

        val list = pre.getOrDefault(curr, mutableListOf<Int>()).toList()
        for(n: Int in list){
            if(!vis[n]){
                if(findHelper(n, vis,recPath, stack, pre)){
                    return true
                }
            }else{
                if(recPath[n]){
                    return true
                }
            }
        }

        stack.addLast(curr)
        recPath[curr] = false
        return false
    }
}
