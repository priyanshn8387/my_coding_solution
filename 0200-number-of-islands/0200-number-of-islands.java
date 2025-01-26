class Solution {

    public void dfs(int i, int j, char[][] grid, boolean [][] visited){

    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j]=='0'){
        return;
    }

    visited[i][j]=true;

    int[][] dirs = {{i-1,j},{i,j+1},{i+1,j},{i,j-1}};

    for(int[] dir : dirs){
        int i_=dir[0];
        int j_=dir[1];

        dfs(i_,j_,grid,visited);
    }

    }
    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int islandCount =0;

        boolean [][] visited = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,grid,visited);
                    islandCount++;
                }
            }
        }

        return islandCount;
        
    }
}