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
    private void paths(TreeNode root, StringBuilder current, List<String> result) {
        if (root == null) {
            return;
        }

        int length = current.length();

        if (length > 0) {
            current.append("->");
        }

        current.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(current.toString());
        } else {
            paths(root.left, current, result);
            paths(root.right, current, result);
        }

        current.setLength(length);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        paths(root, new StringBuilder(), result);
        return result;
    }
}