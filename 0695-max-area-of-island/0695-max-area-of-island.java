class Solution {

    public int dfs(int i, int j, int[][]grid, boolean [][]visited){

    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || visited[i][j]){
        return 0;
    }

    visited[i][j]=true;
    int count=1;

    int[][] dirs = {{i-1,j},{i,j+1},{i+1,j},{i,j-1}};
    for(int[] dir : dirs){
        int i_=dir[0];
        int j_=dir[1];

        count+=dfs(i_,j_,grid,visited);
    }

    return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        

        int row = grid.length;
        int col = grid[0].length;
        int areaMax = 0;
        boolean[][] visited = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int area = dfs(i,j,grid,visited);
                    areaMax=Math.max(areaMax,area);
                   
                }
            }
        }

        return areaMax;
    }
}