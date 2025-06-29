class Solution {
    HashSet<Integer> set;
    int result = 0;

    public int countArrangement(int n) {
        set = new HashSet<Integer>();
        backtrack(n, 1);
        return result;
    }

    private void backtrack(int n, int index) {
        // base
        if (set.size() == n) {
            result = result +1;
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!set.contains(i)) {
                if(i % index == 0 || index % i == 0){
                    set.add(i);
                    backtrack(n, index  +1);
                    set.remove(i);
                }
                
            }

        }
    }
}