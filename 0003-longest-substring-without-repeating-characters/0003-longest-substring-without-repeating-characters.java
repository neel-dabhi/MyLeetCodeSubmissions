class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lss=0;

        for(int i=0; i< s.length(); i++){
            int count = 0;
            List<Character> visited = new ArrayList<Character>();
            for(int j=i; j< s.length(); j++){
                if(!visited.contains(s.charAt(j))){
                    visited.add(s.charAt(j));
                    count = count + 1;
                    if (count >= lss){lss = count;}
                }else{
                    break;
                }
            }
        }
        return lss;
    }
}