class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sSt = new Stack<>();
        Stack<Character> tSt = new Stack<>();

        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);

            if(!sSt.isEmpty() && ch == '#'){
                sSt.pop();
                continue;
            }else if(sSt.isEmpty() && ch == '#'){
                continue;
            }
            sSt.push(ch);
        }

         for(int i=0; i< t.length(); i++){
            char ch = t.charAt(i);
            if(!tSt.isEmpty() && ch == '#'){
                tSt.pop();
                continue;
            }else if(tSt.isEmpty() && ch == '#'){
                continue;
            }
            tSt.push(ch);
        }

        StringBuilder tSB = new StringBuilder();

        while(!tSt.isEmpty()){
            tSB.insert(0, tSt.pop());
        }

        StringBuilder sSB = new StringBuilder();
        while(!sSt.isEmpty()){
            sSB.insert(0, sSt.pop());
        }

        return (tSB.toString()).equals(sSB.toString());
    }
}