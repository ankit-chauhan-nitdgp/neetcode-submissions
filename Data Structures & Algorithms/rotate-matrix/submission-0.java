class Solution {
    public void rotate(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;

        for(int i = 0; i< rLen/2; i++){
            int counterRow = rLen-1-i;
            for(int j = 0; j<cLen ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[counterRow][j];
                matrix[counterRow][j] = temp;
            }
        }

        for(int i = 0; i< rLen; i++){
            for(int j = 0 ; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return;
    }
}
