class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int[] visited = new int[grid.length * grid.length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if(visited[grid[i][j] -1] == 0){
                    visited[grid[i][j] -1] = grid[i][j];
                }else{
                    ans[0] =grid[i][j];
                }
                
            }
        }

        for(int i=0; i< visited.length; i++){
            if(visited[i] == 0){
                ans[1] = i+1;
            }
        }
        return ans;
    }
}