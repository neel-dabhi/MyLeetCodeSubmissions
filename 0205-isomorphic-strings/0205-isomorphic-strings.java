class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> stMap = new HashMap<Character, Character>();
        HashMap<Character, Character> tsMap = new HashMap<Character, Character>();

        if(s.length() != t.length()) return false;

        for(int i=0; i< s.length(); i++){
            Character S = s.charAt(i);
            Character T = t.charAt(i);
            
            if(stMap.containsKey(S) == false){
                stMap.put(S, T);
            }

            if(stMap.get(S) != T){
                return false;
            }

            if(tsMap.containsKey(T) == false){
                tsMap.put(T, S);
            }

            if(tsMap.get(T) != S){
                return false;
            }
        }
        return true;
    }
}