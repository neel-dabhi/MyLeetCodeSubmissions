// TC: O(n)
// SC: O(h)
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root != null){

            while(root!= null){
                st.push(root);
                root = root.left;
            }
            System.out.println(st.peek().val);
            root = st.pop();
            result.add(root.val);
            root = root.right;
        }   

        return result;
    }
}