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
    private int sum = 0;

    private void leaf(TreeNode root, List<Integer> current) {
        if (root == null) {
            return;
        }

        current.add(root.val);

        if (root.left == null && root.right == null) {
            int num = 0;

            for (int n : current) {
                num = num * 10 + n;
            }

            sum += num;
            current.remove(current.size() - 1);
            return;
        }

        leaf(root.left, current);
        leaf(root.right, current);
        current.remove(current.size() - 1);
    }

    public int sumNumbers(TreeNode root) {
        leaf(root, new ArrayList<>());
        return sum;
    }
}