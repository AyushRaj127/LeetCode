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
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + depth(root.right);
        }

        if (root.right == null) {
            return 1 + depth(root.left);
        }

        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);

        return 1 + Math.min(leftHeight, rightHeight);
    }

    public int minDepth(TreeNode root) {
        return depth(root);
    }
}