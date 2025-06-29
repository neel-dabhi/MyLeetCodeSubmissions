class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int sum=0;
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                sum = sum +2;
                set.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }  
        } 

        if(set.isEmpty()){
            return sum;
        }

        return sum +1;
    }
}