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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Integer> index = new ArrayDeque<>();

        q.offer(root);
        index.offer(0);
        int width = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = index.peek();
            
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                int idx = index.poll();
                int nextIndex = idx - minIndex;
                TreeNode curr = q.poll();

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (curr.left != null) {
                    q.offer(curr.left);
                    index.offer(2 * nextIndex + 1);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                    index.offer(2 * nextIndex + 2);
                }
            }

            width = Math.max(width, last - first + 1);
        }

        return width;
    }
}