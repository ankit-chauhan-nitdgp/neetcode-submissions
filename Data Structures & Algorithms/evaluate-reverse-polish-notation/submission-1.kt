class Solution {
    
    val stack = ArrayDeque<Int>();
    fun evalRPN(tokens: Array<String>): Int {
        // assuming only valid cas
        // two operands per operator

        for(token: String in tokens){
            when(token){
                "+" -> {
                    val b = stack.removeLast()
                    val a = stack.removeLast()
                    stack.add(a+b)
                }
                "-" -> {
                    val b = stack.removeLast()
                    val a = stack.removeLast()
                    stack.add(a-b)
                }
                "*" -> {
                    val b = stack.removeLast()
                    val a = stack.removeLast()
                    stack.add(a*b)
                }
                "/" -> {
                    val b = stack.removeLast()
                    val a = stack.removeLast()
                    stack.add(a/b)
                }
                else -> {
                    stack.add(token.toInt())
                }
            }
        }

        return stack.removeLast()
    }
}
