class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        if(num.length() == k){
            return "0";
        }

        for (int i = 0; i < num.length(); i++) {
            int curr = num.charAt(i) - '0';

            while (!st.isEmpty() && st.peek() > curr && k > 0) {
                // logic
                st.pop();
                k--;
            }
            if(st.isEmpty() && curr ==0){
                continue;
            }
            st.push(curr);
            
        }

        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            return "0";
        }

        while(!st.isEmpty()){
            sb.append(st.pop() + "");
        }
        
        return sb.reverse().toString();
    }
}