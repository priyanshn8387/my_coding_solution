class Solution {

    public void dfs(int i, int j, int[][] image, boolean [][] visited, int initialColor, int targetColor){

    if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=initialColor || visited[i][j]){
            return;
        }

        // fillthe color
        visited[i][j]=true;
        image[i][j]=targetColor;

        int[][] dirs = {{i-1,j},{i,j+1},{i+1,j},{i,j-1}};
        for(int[] dir : dirs){
            int i_ = dir[0];
            int j_ = dir[1];

            dfs(i_,j_,image,visited,initialColor,targetColor);

        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int row = image.length;
        int col = image[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==sr && j==sc && !visited[i][j]){
                    dfs(i,j,image,visited,image[sr][sc],color);
                }
            }
        }

        return image;
        
    }
}