class Solution {
    public boolean validMountainArray(int[] arr) {
        
        int i=0;
        if (arr.length < 3 ){
            return false;
        }

        for(i=0; i< arr.length -1; i++){
            if(arr[i+1] < arr[i]){
                break;
            }
            if (arr[i] == arr[i+1]){
                return false;
            }
        }

        if(i == arr.length -1 || i==0){
            return false; 
        }

        int j =0;
        for(j=i; j < arr.length -1; j++){
            if(arr[j] < arr[j+1]){
                return false; 
            }
            if (arr[j] == arr[j+1]){
                return false;
            }
        }

        return true;
        
    }
}