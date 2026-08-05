//tc= O(rows * cols)  //sc = O(rows * cols)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]>q = new LinkedList<>();
        int [][] distance = new int [rows][cols];

        for(int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                    distance[i][j]=0;
                }else{
                    distance[i][j]=-1;
                }
            }
        }
            int[][]directions={
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
            };
            while(!q.isEmpty()){
                    int [] curr = q.poll();
                    int row = curr [0];
                    int col = curr [1];
                    for(int[] dir : directions){
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];
                        if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && distance[newRow][newCol]==-1){
                            distance[newRow][newCol]=distance[row][col] + 1;
                            q.offer(new int[] {newRow,newCol});
                        }
                    }
                }
            
            return distance;
        
    }
}