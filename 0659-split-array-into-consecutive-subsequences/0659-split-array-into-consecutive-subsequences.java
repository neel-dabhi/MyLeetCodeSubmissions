class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> canJoinMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (canJoinMap.containsKey(num) && freqMap.containsKey(num)) {
                // num can join existing subsequences

                freqMap.put(num, freqMap.get(num) - 1);
                if (freqMap.get(num) == 0)
                    freqMap.remove(num);

                canJoinMap.put(num, canJoinMap.get(num) - 1);
                if (canJoinMap.get(num) == 0)
                    canJoinMap.remove(num);

                // create num + 1 in canJoinMap
                canJoinMap.put(num + 1, canJoinMap.getOrDefault(num + 1, 0) + 1);

            } else if (freqMap.containsKey(num)) {
                // if num cant join existing, check if it can build its own subsequences
                if (freqMap.containsKey(num + 1) && freqMap.containsKey(num + 2)) {
                    // can build their own subsequence
                    freqMap.put(num, freqMap.get(num) - 1);
                    freqMap.put(num + 1, freqMap.get(num + 1) - 1);
                    freqMap.put(num + 2, freqMap.get(num + 2) - 1);

                    // delete if zero
                    if (freqMap.get(num) == 0)
                        freqMap.remove(num);
                    if (freqMap.get(num + 1) == 0)
                        freqMap.remove(num + 1);
                    if (freqMap.get(num + 2) == 0)
                        freqMap.remove(num + 2);

                    // put num + 3 in canJoinMap
                    canJoinMap.put(num + 3, canJoinMap.getOrDefault(num + 3, 0) + 1);
                } else {
                    // cant join existing or make new 
                    return false;
                }
            }
        }
        return true;
    }
}