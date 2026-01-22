class Solution {

    public boolean dfs(int i, int j, char[][] board, String word, int index){

        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(index) || board[i][j]=='#') return false;

        if(word.length()==index+1) return true;

        char current = board[i][j];
        board[i][j]='#';

        boolean right = dfs(i,j+1,board,word,index+1);
        boolean bottom = dfs(i+1,j,board,word,index+1);
        boolean left = dfs(i,j-1,board,word,index+1);
        boolean top = dfs(i-1,j,board,word,index+1);



        // backtrack
        board[i][j]=current;

        return (right || bottom || left || top);

    }
    public boolean exist(char[][] board, String word) {
        

        int row = board.length;
        int col = board[0].length;


        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                     if (dfs(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;

        
    }
}