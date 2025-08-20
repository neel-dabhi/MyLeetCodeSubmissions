/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> st = new Stack<>();
        int result = 0;
        while(!st.isEmpty() || root != null){
            // go all the way left
            while(root != null){
                st.push(root);
                root = root.left;
            }
            // process root
            root = st.pop();
            if(root.val >= low && root.val <= high){
                result = result + root.val;
            }
            
            // now go right
            root = root.right;
            

        }
        return result;
    }

}