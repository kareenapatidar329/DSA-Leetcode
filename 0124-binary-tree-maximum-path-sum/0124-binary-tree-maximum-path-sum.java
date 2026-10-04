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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gain(root);
        return maxSum;
    }

    private int gain(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Negative contribution ko ignore karo
        int leftGain = Math.max(0, gain(root.left));
        int rightGain = Math.max(0, gain(root.right));

        // Current node ke through complete path
        int currentPath = root.val + leftGain + rightGain;

        // Global maximum update
        maxSum = Math.max(maxSum, currentPath);

        // Parent ko sirf ek side ka gain de sakte hain
        return root.val + Math.max(leftGain, rightGain);
    }
}