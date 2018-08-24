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
    int ret;
    public int longestUnivaluePath(TreeNode root) {
        ret = 0;
        postOrder(root);
        return ret;
    }
    
    public int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = postOrder(root.left);
        int rightDepth = postOrder(root.right);
        
        int lhs = 0;
        int rhs = 0;
        if (root.left != null && root.val == root.left.val) {
            lhs = leftDepth + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rhs = rightDepth + 1;
        }
        ret = Math.max(ret, lhs + rhs);
        return Math.max(lhs, rhs);
        
    }
}
