class Solution {

    public int dfs(int i, int j, int[][] grid){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return 1;
        }

        if(grid[i][j]==-1) return 0;

        grid[i][j]=-1;

        int right = dfs(i,j+1,grid);
        int bottom = dfs(i+1,j,grid);
        int left = dfs(i,j-1,grid);
        int top = dfs(i+1,j,grid);

        return right+bottom+left+top;


    }
    public int islandPerimeter(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int total =0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    total+=dfs(i,j,grid);
                }
            }
        }

        return total;
        
    }
}