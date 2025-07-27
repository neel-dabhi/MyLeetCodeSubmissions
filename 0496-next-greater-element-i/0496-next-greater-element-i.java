// TC: O(nums1.length + nums2.length)
// SC: O(nums2.length)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> st = new Stack<Integer>();
        int[] result = new int[nums1.length];

        for(int i=0; i< nums2.length; i++){

            while(!st.isEmpty() && st.peek() < nums2[i]){
                map.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }

        for(int i=0; i< nums1.length; i++){
            if(map.containsKey(nums1[i])){
                result[i] = map.get(nums1[i]); 
            }else{
                result[i] = -1;
            }
        }

        return result; 

    }
}