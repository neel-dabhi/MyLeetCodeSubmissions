class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length -1;

        while(j >= 0 && i <= matrix.length -1){
            if(matrix[i][j] == target){
                return true;
            }else if(target < matrix[i][j]){
                j--;
            }else if(target > matrix[i][j]){
                i++;
            }
        }
        return false;

    }
}