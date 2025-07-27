class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        StringBuffer sb = new StringBuffer();

        if(num.length() == k){
            return "0";
        }
        // 1 4 3 2 2 1 9
        for (int i = 0; i < num.length(); i++) {
            int curr = Integer.parseInt(num.charAt(i) + "");

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