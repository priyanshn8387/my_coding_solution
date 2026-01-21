class Solution {

    public int dfs(int i, int j, int[][] grid, boolean[][] visited){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 || visited[i][j]){
            return 0;
        }

        visited[i][j]=true;
        int count=1;

        count+=dfs(i,j+1,grid,visited);
        count+=dfs(i-1,j,grid,visited);
        count+=dfs(i,j-1,grid,visited);
        count+=dfs(i+1,j,grid,visited);

        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {

        // solve withhout visited array, ask to interviewer first can i modify the existing array, if no, then use visted array

        // TC -> O(row*col)
        // SC : O(row*col) (recursion stack)

        int row = grid.length;
        int col = grid[0].length;
        boolean [][] visited = new boolean[row][col];
        int maxi = Integer.MIN_VALUE;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int area = dfs(i,j,grid,visited);
                    maxi=Math.max(maxi,area);
                }
            }
        }

        return maxi==Integer.MIN_VALUE ? 0 : maxi;
        
    }
}