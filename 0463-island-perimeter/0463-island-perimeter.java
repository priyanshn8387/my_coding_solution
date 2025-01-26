class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int count =0;


        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){

                    // top (checking outofbound and water condition)
                    if(i>0 && grid[i-1][j]==0 || i==0) count++;
                    // right
                    if(j<col-1 && grid[i][j+1]==0 || j==col-1) count++;
                    // left
                    if(i<row-1 && grid[i+1][j]==0 || i==row-1) count++;
                    // bottom
                    if(j>0 && grid[i][j-1]==0 || j==0) count++;
                }
            }
        }

        return count;
    }
}