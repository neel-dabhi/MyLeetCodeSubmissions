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
    List<TreeNode> preOrderList = new ArrayList<TreeNode>();

    public void flatten(TreeNode root) {
        preorder(root);

        TreeNode prev = null;
        for (TreeNode node : preOrderList) {
            if (prev != null) {
                prev.right = node;
                prev.left = null;
            } 
            prev = node;
        }
    }

    private void preorder(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        //logic 
        preOrderList.add(root);

        preorder(root.left);
        preorder(root.right);
    }
}