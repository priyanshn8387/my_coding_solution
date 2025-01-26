class Solution {

    public boolean dfs(int i, int j, char[][] grid, boolean [][] visited, String word, int wordIndex){

    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j]!=word.charAt(wordIndex)){
        return false;
    }

    if(wordIndex==word.length()-1) return true;

    visited[i][j]=true;

    int[][] dirs = {{i-1,j},{i,j+1},{i+1,j},{i,j-1}};

    for(int[] dir : dirs){
        int i_=dir[0];
        int j_=dir[1];

        if(dfs(i_,j_,grid,visited,word,wordIndex+1)){
            return true;
        }

       
    }

     // Backtrack: unmark the cell as visited
        visited[i][j] = false;

        return false; // No valid path found
    }

    public boolean exist(char[][] board, String word) {
        
         int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        // Start DFS from every cell that matches the first character of the word
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, visited, word, 0)) {
                        return true; // Return true if a valid path is found
                    }
                }
            }
        }

        return false; // Return false if no path is found
    }
}