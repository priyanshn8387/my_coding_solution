class Solution {

    public void reverse(int[][] matrix, int left, int right, int row) {

        while (left < right) {
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;

            left++;
            right--;
        }
    }

    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // transpose
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each row
        for (int i = 0; i < m; i++) {
            reverse(matrix, 0, n - 1, i);
        }
    }
}
