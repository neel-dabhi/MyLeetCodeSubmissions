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
    Set<TreeNode> set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> toDel = new HashSet<>();
        for (int i : to_delete) {
            toDel.add(i);
        }

        set = new HashSet();

        ArrayList<TreeNode> result = new ArrayList<>();
        helper(root, toDel, true);
        for (TreeNode i : set) {
            result.add(i);
        }
        return result;
    }

    private TreeNode helper(TreeNode root, Set<Integer> toDel, boolean isRoot) {
        if (root == null) {
            return null;
        }
        boolean deleted = toDel.contains(root.val);

        if (isRoot && !toDel.contains(root.val)) {
            set.add(root);
        }

        root.left = helper(root.left, toDel, deleted);
        root.right = helper(root.right, toDel, deleted);
        
        if(deleted) return null;
        return root;
    }
}