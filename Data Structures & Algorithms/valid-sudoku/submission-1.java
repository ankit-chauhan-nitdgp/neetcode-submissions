class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i< 9; i++){
            for(int j = 0; j< 9; j++){
                char curr = board[i][j];
               if(curr != '.'){
                 //1. check row
                for(int k = 0; k< 9; k++){
                    if(k != j && board[i][k] == curr){
                        return false;
                    }
                }
                //2. check column

                for(int k = 0; k< 9; k++){
                    if(k != i && board[k][j] == curr){
                        return false;
                    }
                }

                //3. check block
                int newI = (i/3)*3;
                int newJ = (j/3)*3;
                System.out.println(newI+" "+newJ);
                for(int p = newI; p<=newI+2; p++){
                    for(int q = newJ; q<=newJ+2; q++){
                        if(i != p && j !=q && board[i][j] == board[p][q]){
                            return false;
                        }
                    }
                }
                }
            }
        }

        return true;
        
    }
}
