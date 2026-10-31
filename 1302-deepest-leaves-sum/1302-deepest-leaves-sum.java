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
    private int depthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depthOfTree(root.left), depthOfTree(root.right));
    }

    private int leaf(TreeNode root, int current, int depth) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (current == depth) {
                return root.val;
            }

            return 0;
        }

        return leaf(root.left, current + 1, depth) + leaf(root.right, current + 1, depth);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        int depth = depthOfTree(root);
        return leaf(root, 1, depth);
    }
}