//tc=O(m*n)  //sc= O(rows*cols)

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]>q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2){
                    q.offer(new int[] {i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int time=0;
        int[][]directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for(int[]dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol]==1){
                        grid[newRow][newCol]=2;
                        fresh--;
                        q.offer(new int[]{newRow,newCol});
                    }
                }
            }
            if(!q.isEmpty()){
                time++;
            }
        }
        return fresh == 0? time : -1;
    }
}