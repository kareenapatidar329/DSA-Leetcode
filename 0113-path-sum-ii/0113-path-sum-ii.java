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
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        findPaths(root, targetSum, currentPath, ans);

        return ans;
    }

    private void findPaths(
            TreeNode root,
            int targetSum,
            List<Integer> currentPath,
            List<List<Integer>> ans) {

        if (root == null) {
            return;
        }

        // Add current node to the path
        currentPath.add(root.val);

        // Subtract current node's value from target
        targetSum -= root.val;

        // Check whether we reached a leaf
        if (root.left == null && root.right == null) {

            if (targetSum == 0) {
                ans.add(new ArrayList<>(currentPath));
            }

        } else {
            // Explore both subtrees
            findPaths(root.left, targetSum, currentPath, ans);
            findPaths(root.right, targetSum, currentPath, ans);
        }

        // Backtrack: remove current node
        currentPath.remove(currentPath.size() - 1);
    }
}