class Solution {
    List<List<String>> ans = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n;i++){
            sb.append('.');
        }
        List<String> list = new ArrayList<String>();
         for(int i =0; i<n;i++){
            list.add(sb.toString());
        }

        ListMaker(n, 0, list);
        return ans;

    }

    private void ListMaker(int n, int i, List<String> list
    ){
        if(i == n){
            ans.add(new ArrayList<String>(list));
            return;
        }

        String str = list.get(i);
        StringBuilder sb = new StringBuilder(str);

        for(int j = 0; j<n;j++){
            if(isValid(i,j,list,n)){
                sb.setCharAt(j, 'Q');
                list.set(i, sb.toString());
                ListMaker(n, i+1, list);
                sb.setCharAt(j,'.');
                list.set(i, sb.toString());
            }
        }
        return;
    }

    private boolean isValid(int i, int j, List<String> 
    list, int n){
        for(int p = 0 ; p< j; p++){
            if(list.get(i).charAt(p) == 'Q'){
                return false;
            }
        }

        for(int p=0;p<=i-1;p++){
            int diff = i-p;
            int leftDiag = j-diff;
            int rightDiag = j+diff;
            if(list.get(p).charAt(j) == 'Q'){
                return false;
            }else if(leftDiag >= 0 && 
            list.get(p).charAt(leftDiag) == 'Q'){
                return false;
            }else if(rightDiag < n && 
            list.get(p).charAt(rightDiag) == 'Q'){
                return false;
            }
        }

        return true;
    }


}
