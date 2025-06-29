class Solution {
    public boolean checkPowersOfThree(int n) {
        
        for(int i=16; i >=0; i--){
            if (Math.pow(3,i) <= n){
                n = n - (int)Math.pow(3,i);
                if(n==0){return true;}   
            }
        }
        return false;
    }
}