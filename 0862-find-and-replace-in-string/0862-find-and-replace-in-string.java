// TC: O(n ^ 2)
// SC: O(n)
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        // indices are not sorted so store it in map
        // for loop i will take care of sorting
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            int key = indices[i];
            List<String> values = new ArrayList<>();
            values.add(sources[i]); // 0 sources
            values.add(targets[i]); // 1 targets

            // additional fiter add indices for which we have substings in s
            if (indices[i] + sources[i].length() <= s.length()) {
                String sub = s.substring(indices[i], indices[i] + sources[i].length());
                if (sources[i].equals(sub)) {
                    map.put(key, values);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(i)) {
                // we already did matching at map
                String matched = map.get(i).get(0);
                String toAppend = map.get(i).get(1);
                result.append(toAppend);
                i = i + matched.length() -1;
            } else {
                // do nothing
                char ch = s.charAt(i);
                result.append(ch);
            }
        }
        return result.toString();
    }
}

// a b c d 
// 0 1 2 3

// i = 0 in map
// s = a...
// source = a
// target = eee

// source matches s
// result = eee
// -----------------
// i = 1 not in map 
// s = b...
// do nothing append b
// result = eeeb
// -----------------
// i = 2 in map 
// s = c...
// source = cd
// target = ffff

// source matches s
// result = eeebffff
