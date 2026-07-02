class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        makeParenthesisList(new StringBuilder(), 0, n);
        return ans;
    }

    private void makeParenthesisList(StringBuilder sb, int sum, int n){

        if(sb.length() > n*2){
            return;
        }
        if(sb.length() == n*2 && sum == 0){
            ans.add(new String(sb.toString()));
            return;
        }

        if(sum - 1 >= 0){
            sb.append(')');
            makeParenthesisList(sb, sum-1, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(sum+1 <= n){
            sb.append('(');
            makeParenthesisList(sb, sum+1, n);
            sb.deleteCharAt(sb.length()-1);
        }

        return;
    }   
}
