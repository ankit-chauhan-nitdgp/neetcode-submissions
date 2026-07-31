class Solution {

    lateinit var dp: Array<IntArray>
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val len1 = text1.length
        val len2 = text2.length
        dp = Array(len1+1){IntArray(len2+1)}
        for(i:Int in 0..len1){
            for(j: Int in 0.. len2){
                dp[i][j] = -1
            }
        }

        return lcsHelper(text1, text2, len1, len2)
    }

    fun lcsHelper(text1: String, text2: String, len1: Int, len2: Int) : Int{
        // base case
        if(len1 == 0 || len2 == 0){
             return 0
        }

        if(dp[len1][len2] != -1){
            return dp[len1][len2]
        }
        
        // choice
        if(text1[len1-1] == text2[len2-1]){
            dp[len1][len2] = 1+lcsHelper(text1, text2, len1-1, len2-1)
            return dp[len1][len2]
        }else{
            dp[len1][len2] = max(lcsHelper(text1, text2, len1-1, len2), lcsHelper(text1, text2, len1, len2-1))
            return dp[len1][len2]
        }
    }
}
