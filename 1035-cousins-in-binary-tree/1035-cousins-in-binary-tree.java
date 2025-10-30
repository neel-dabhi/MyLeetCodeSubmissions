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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        boolean xFound = false;
        boolean yFound = false;

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = bfs.poll();

                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x || curr.left.val == y) && (curr.right.val == x || curr.right.val == y)) {
                        return false;
                    }
                }

                if (curr.val == x) {
                    xFound = true;
                }
                if (curr.val == y) {
                    yFound = true;
                }
                if (curr.left != null) {
                    bfs.add(curr.left);
                }

                if (curr.right != null) {
                    bfs.add(curr.right);
                }

            }

            if ((!xFound && yFound) || (xFound && !yFound)) {
                return false;
            }
        }

        return xFound && yFound;

    }
}