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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // [3,9,20,15,7]
        // [9,3,15,20,7]
        int n = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, preorder, inorder);
    }

    private TreeNode helper(HashMap<Integer, Integer> map, int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
            }
        }

        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, 1 + leftInOrder.length);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, 1 + leftInOrder.length, preorder.length);

        TreeNode left = helper(map, leftPreOrder, leftInOrder);
        TreeNode right = helper(map, rightPreOrder, rightInOrder);

        return new TreeNode(rootVal, left, right);

    }

}