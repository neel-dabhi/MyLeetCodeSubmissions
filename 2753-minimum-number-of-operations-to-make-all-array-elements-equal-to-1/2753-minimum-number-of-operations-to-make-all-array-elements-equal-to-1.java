class Solution {
    public int minOperations(int[] nums) {
        int countOnes = 0;

        for (int i : nums) {
            if (i == 1) {
                countOnes++;
            }
        }

        if (countOnes > 0) {
            return nums.length - countOnes;
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            for(int j = i + 1; j< nums.length; j++){
                gcd = getGCD(gcd, nums[j]);
                if (gcd == 1) {
                    ans = Math.min(ans, j - i);
                    break;
                }
            }   
        }

        if(ans == Integer.MAX_VALUE) return -1;
        
        return ans +  nums.length-1;
    }

    private int getGCD(int x, int y) {
        int result = Math.min(x, y);

        while (result > 0) {
            if (x % result == 0 && y % result == 0) {
                break;
            }
            result--;
        }

        return result;
    }
}