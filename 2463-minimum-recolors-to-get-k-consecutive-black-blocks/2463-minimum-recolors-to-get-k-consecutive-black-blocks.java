class Solution {
    public int minimumRecolors(String blocks, int k) {
        int output=10000;
        for(int i=0; i< blocks.length(); i++){
            if(i+k <= blocks.length()){
                int whites =0;
                for(int j=i; j< i+k; j++){

                    if(blocks.charAt(j) == 'W'){
                        whites++;
                    }
                }
                if(output > whites){
                    output = whites;
                }
            }
            
        }
        return output;
    }
}