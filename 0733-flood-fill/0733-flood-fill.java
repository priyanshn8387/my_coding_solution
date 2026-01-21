class Solution {

    public void dfs(int i, int j, int[][] image,int targetColor, int initialColor){

    if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=initialColor || image[i][j]==targetColor){
            return;
        }

        // fillthe color
        image[i][j]=targetColor;

        dfs(i,j+1,image,targetColor,initialColor);
        dfs(i-1,j,image,targetColor,initialColor);
        dfs(i,j-1,image,targetColor,initialColor);
        dfs(i+1,j,image,targetColor,initialColor);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int row = image.length;
        int col = image[0].length;

        int initialColor = image[sr][sc];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==sr && j==sc){
                    dfs(i,j,image,color,initialColor);
                }
            }
        }

        return image;
        
    }
}