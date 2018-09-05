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
    int minVal;
    long ret = Long.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
        minVal = root.val;
        dfs(root);
        return ret < Long.MAX_VALUE ? (int)ret : -1;
    }
    
    public void dfs(TreeNode root) {
        if (root != null) {
            if (minVal < root.val && root.val < ret) {
                ret = root.val;
            } else if (minVal == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
}
