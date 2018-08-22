/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (null == root.left && null == root.right && root.val == 0) {
            return null;
        }

        return root;
    }
}
