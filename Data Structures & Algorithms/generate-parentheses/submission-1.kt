class Solution {
    var ans = mutableListOf<String>()
    fun generateParenthesis(n: Int): List<String> {
        val sb = StringBuilder()
        helper(n, 0, sb, 0)

        return ans
    }

    fun helper(n: Int, idx: Int, result: StringBuilder, sum: Int) {
        if(sum < 0 || idx > n*2){
            return
        }

        if(idx == n*2 && sum == 0){
            ans.add(result.toString())
            return
        }

        result.append('(')
        helper(n, idx+1, result, sum+1)
        result.setLength(result.length - 1)
        result.append(')')
        helper(n, idx+1, result, sum-1)
        result.setLength(result.length - 1)

        return
    }
}
