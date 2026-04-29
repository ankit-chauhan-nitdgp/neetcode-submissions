class Solution {
    int[][] pointer ={{0,1},{0,-1}, {1, 0},{-1, 0}};
    int rows, cols;

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        if(rows < 3 || cols <3){
            return;
        }

   
        boolean[][] visited =  new boolean[rows][cols];

        // System.out.println("vis1");
        //  for(int i = 0; i < rows; i++){
        //     for(int j = 0; j < cols; j++){
        //         System.out.print(" "+visited[i][j]);
        //     }
        //  }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if( i == 0 || i == rows-1 || j == 0 || j == cols-1){
                    if(board[i][j] == 'O' && !visited[i][j]){
                        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
                        q.add(new Pair(i, j));
                        bfs(visited, board, q);

                    }
                        
                }
        }
        }
        // System.out.println("\nvis 2");

        // for(int i = 0; i < rows; i++){
        //     for(int j = 0; j < cols; j++){
        //         System.out.print(" "+visited[i][j]);
        //     }
        //  }

        


        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }

            }
        }

            return;
    }

        public void bfs(boolean[][] vis, char[][] board, Queue<Pair<Integer, Integer>> q){

        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.remove();
            int row = p.getKey();
            int col = p.getValue();
            vis[row][col] = true;

            for(int[] item: pointer){
                    int newRow = row + item[0];
                    int newCol = col + item[1];

                    if(  newRow < rows && newRow >=0 &&
                     newCol < cols && newCol >=0 &&
                     !vis[newRow][newCol] &&
                     board[newRow][newCol] == 'O'){
                        q.add(new Pair(newRow, newCol));
                    }

                }
        }
        }

    

}
