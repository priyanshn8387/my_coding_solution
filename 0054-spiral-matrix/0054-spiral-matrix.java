class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int top=0;
        int left =0;
        int right =col-1;
        int bottom = row-1;

        List<Integer> res = new ArrayList<>();

        while(top <= bottom && left <= right){

            for(int j=left;j<=right;j++){
                res.add(matrix[top][j]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;

            // FIX 2: boundary check
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // FIX 3: boundary check
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
        
    }
}