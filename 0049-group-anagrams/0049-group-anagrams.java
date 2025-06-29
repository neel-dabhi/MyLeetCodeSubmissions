class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);

            if(map.get(sortedString) == null){
                map.put(sortedString, new ArrayList<String>());
            }
            map.get(sortedString).add(str);
        }

        return new ArrayList<List<String>>(map.values());
    }
}