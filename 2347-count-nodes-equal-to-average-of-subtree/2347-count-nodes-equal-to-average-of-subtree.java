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
    int result;

    public int averageOfSubtree(TreeNode root) {
        result = 0;
        helper(root);
        return result;
    }

    private int[] helper(TreeNode root) {

        if (root == null) {
            return new int[] { 0, 0 }; // running sum, # nodes so far
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int avg = (left[0] + right[0] + root.val) / (left[1] + right[1] + 1);

        if (root.val == avg) {
            result++;
        }

        return new int[] { (left[0] + right[0] + root.val), (left[1] + right[1] + 1) };

    }
}