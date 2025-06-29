class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        Map<Integer, Integer> tm = new TreeMap<Integer, Integer>();
       
        for(int i=0; i< nums1.length; i++){
            tm.put( (nums1[i])[0],  (nums1[i])[1]);
        }

        for(int i=0; i< nums2.length; i++){
            if(tm.containsKey( (nums2[i])[0] )){
                tm.put((nums2[i])[0], tm.get((nums2[i])[0]) + (nums2[i])[1] );
            }else{
                tm.put( (nums2[i])[0],  (nums2[i])[1]);
            }
        }

        int[][] result = new int[tm.size()][2];

        int i =0;
        for(Map.Entry<Integer, Integer> e: tm.entrySet()){
            (result[i])[0] = e.getKey();
            (result[i])[1] = e.getValue();
            i++;
        }

        return result;
    }
}