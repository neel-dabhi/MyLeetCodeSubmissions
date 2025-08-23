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
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int curr = root.val -1;
        int left = dfs(root.left);
        int right = dfs(root.right);

        moves = moves + Math.abs(left + right + curr);

        return left + right + curr;
    }
}