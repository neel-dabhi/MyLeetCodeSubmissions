// TC : O(2n)
// SC : O(n)
class Solution {
    class CharFreq {
        int frequency = 0;
        char character = ' ';

        CharFreq(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }

    public String reorganizeString(String s) {
        PriorityQueue<CharFreq> pq = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
        HashMap<Character, Integer> map = new HashMap();

        // Build map to count frequency 
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, 0);
            }
            map.put(curr, map.get(curr) + 1);
        }

        // Build Max Heap form Map
        for (char key : map.keySet()) {
            pq.add(new CharFreq(key, map.get(key)));
        }


        StringBuilder sb = new StringBuilder();
        CharFreq prev = null;

        while (!pq.isEmpty()) {

            CharFreq curr = pq.poll();
            
            sb.append(curr.character);
            curr.frequency--;

            if (prev != null && prev.frequency > 0) {
                pq.add(prev);
            }
            prev = curr;
        }
        if(sb.length() != s.length()) return "";
        return sb.toString();
    }
}