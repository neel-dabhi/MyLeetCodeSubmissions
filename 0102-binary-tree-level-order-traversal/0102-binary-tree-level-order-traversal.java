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
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (result.size() - 1 < level) {
            result.add(level, new ArrayList<Integer>());
        }

        result.get(level).add(root.val);

        helper(root.left, level + 1);
        helper(root.right, level + 1);

    }
}