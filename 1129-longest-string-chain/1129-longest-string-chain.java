class Solution {
    public int longestStrChain(String[] words) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(words));
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        Queue<String> bfs = new LinkedList<String>();
        Queue<Integer> level = new LinkedList<Integer>();

        for (String word : words) {
            bfs.add(word);
            level.add(1);
            visited.put(word, 1);
        }

        int result = 1;
        while (!bfs.isEmpty()) {

            StringBuffer curr = new StringBuffer(bfs.poll());
            int lvl = level.poll();

            for (int j = 0; j < curr.length(); j++) {
                char removed = curr.charAt(j);
                // action
                curr.deleteCharAt(j);
                String afterRemoval = curr.toString();

                // process
                if ( lvl +1 > visited.getOrDefault(afterRemoval, 0) && set.contains(afterRemoval)) {
                    bfs.add(afterRemoval);
                    level.add(lvl + 1);
                    result = Math.max(result, lvl+1);
                    visited.put(afterRemoval, lvl+1); 
                }
                // backtrack
                curr.insert(j, removed);
            }
        }
        return result;
    }
}