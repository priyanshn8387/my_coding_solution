class Solution {

    public int dfs(int i, int j, int[][] grid){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }

        grid[i][j]=0;
        int count=1;

        count+=dfs(i,j+1,grid);
        count+=dfs(i-1,j,grid);
        count+=dfs(i,j-1,grid);
        count+=dfs(i+1,j,grid);

        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {

        // solve withhout visited array, ask to interviewer first can i modify the existing array

        // TC -> O(row*col)
        // SC : O(row*col) (recursion stack)

        int row = grid.length;
        int col = grid[0].length;
        int maxi = Integer.MIN_VALUE;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    int area = dfs(i,j,grid);
                    maxi=Math.max(maxi,area);
                }
            }
        }

        return maxi==Integer.MIN_VALUE ? 0 : maxi;
        
    }
}