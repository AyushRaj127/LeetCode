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
    private void paths(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        current.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            return;
        }

        paths(root.left, targetSum - root.val, current, result);
        paths(root.right, targetSum - root.val, current, result);
        current.remove(current.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        paths(root, targetSum, new ArrayList<>(), result);
        return result;
    }
}