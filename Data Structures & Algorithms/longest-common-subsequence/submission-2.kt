class Solution {

    lateinit var dp: Array<IntArray>
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val len1 = text1.length
        val len2 = text2.length
        dp = Array(len1+1){IntArray(len2+1)}
        for(i:Int in 0..len1-1){
            for(j: Int in 0.. len2-1){
                dp[i][j] = -1
            }
        }

        return lcsHelper(text1, text2, len1-1, len2-1)
    }

    fun lcsHelper(text1: String, text2: String, i: Int, j: Int) : Int{
        // base case
        if(i == -1 || j == -1){
             return 0
        }

        if(dp[i][j] != -1){
            return dp[i][j]
        }
        
        // choice
        if(text1[i] == text2[j]){
            dp[i][j] = 1+lcsHelper(text1, text2, i-1, j-1)
            return dp[i][j]
        }else{
            dp[i][j] = max(lcsHelper(text1, text2, i-1, j), lcsHelper(text1, text2, i, j-1))
            return dp[i][j]
        }
    }
}
