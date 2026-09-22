class Solution {

    val ans : MutableSet<List<Int>> = mutableSetOf<List<Int>>()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)
        helper(mutableListOf(), candidates, target, 0)
        return ans.toList()
    }

    fun helper(list:MutableList<Int>, candidates: IntArray, target: Int, idx: Int){

        // println("currList: ${list}")
        if(target == 0){
            // println("insideTarget ${list}")
            val listToAdd = list.toList()
            ans.add(listToAdd)
            return
        }

        if(idx >= candidates.size){
            return
        }

        val curr = candidates[idx]
        // println("belowCurr ${list}")
        if(curr <= target){
            var i = idx+1

            while(i < candidates.size){
                if(candidates[i] == candidates[idx]){
                    i++
                }else{
                    break
                }
            }

            helper(list, candidates, target, i)
            list.add(curr)
            helper(list, candidates, target - curr, idx+1)
            list.removeLast()
        }

    }
}
