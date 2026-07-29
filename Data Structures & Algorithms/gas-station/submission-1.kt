class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val numberOfStation = gas.size
        var totalGas = 0
        var totalCost = 0
        for(g: Int in gas){
            totalGas += g
        }

        for(c: Int in cost){
            totalCost += c
        }

        // no solution
        if(totalGas < totalCost){
            return -1
        }

        // one solution
        var availableGas = 0
        var currentGas = 0
        var result = 0
        var updateResult = true
        for (start : Int in 0..numberOfStation-1){
            currentGas= gas[start]+availableGas
            if(currentGas >= cost[start]){// feasible
                availableGas = currentGas - cost[start]
                if(updateResult){
                    result = start
                    updateResult = false
                }
                
            }else{
                availableGas = 0
                updateResult = true
            }
        }

        return result
    }
}
