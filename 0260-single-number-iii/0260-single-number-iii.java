// TC: O(n)
// SC: O(1)
class Solution {
    public int[] singleNumber(int[] nums) {

        int xorall =0;
        for(int i: nums){
            xorall = xorall ^ i;
        }

        int diffBit = xorall & -xorall;

        int n1 = 0;
        int n2 = 0;

        for (int i: nums){
            if( (i & diffBit) == 0 ){
                n1 = n1 ^ i;
            }else{
                n2 = n2 ^ i;
            }
        }

        return new int[] {n1, n2};
    }
}