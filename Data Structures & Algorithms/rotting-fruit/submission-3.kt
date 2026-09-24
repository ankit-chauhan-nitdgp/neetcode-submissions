class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {

        if(grid.size == 0){
            return -1
        }

        val neigborsRow = arrayOf(-1,0,1,0)
        val neigborsCol = arrayOf(0,-1,0,1)

        val rows = grid.size
        val cols = grid[0].size

        val initialRotten : MutableList<Pair<Int, Int>> = mutableListOf()

        for(row: Int in 0..rows-1){
            for(col: Int in 0..cols-1){
                if(grid[row][col] == 2){
                    initialRotten.add(Pair(row,col))
                }
            }
        }

        val q = ArrayDeque<List<Pair<Int,Int>>>()
        q.addLast(initialRotten.toList())

        val vis = Array(rows){IntArray(cols)}

        var minutes = 0

        while(!q.isEmpty()){
            
            val rottens : List<Pair<Int, Int>> = q.removeFirst()

            if(rottens.isEmpty()){
                continue
            }

            for(rotten : Pair<Int, Int> in rottens){
                vis[rotten.first][rotten.second] = 1
            }

            initialRotten.clear()

            for(rotten : Pair<Int, Int> in rottens){
                for(i: Int in 0..3){
                    val newRow = rotten.first + neigborsRow[i]
                    val newCol = rotten.second + neigborsCol[i]

                    if(newRow >= rows || newRow < 0 || newCol < 0 || newCol >= cols){
                        continue
                    }
                    if(vis[newRow][newCol] == 0 && grid[newRow][newCol] != 0){
                        initialRotten.add(Pair(newRow,newCol))
                        grid[newRow][newCol] = 2
                        vis[newRow][newCol] = 1
                    }
                }
            }

            q.addLast(initialRotten.toList())

            minutes+=1
        }


     for(row: Int in 0..rows-1){
            for(col: Int in 0..cols-1){
                if(grid[row][col] == 1){
                    return -1
                }
            }
    }

        return if(minutes == 0) minutes else minutes-1
    }
}
