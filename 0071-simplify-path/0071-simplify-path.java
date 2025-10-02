class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] dirs = path.split("/");

        for (int i = 0; i < dirs.length; i++) {
            String curr = dirs[i];

            if (curr.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (curr.isEmpty() || curr.equals(".")) {
                continue;
            } else {
                st.push(curr);
            }
        }

        if (st.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }
}