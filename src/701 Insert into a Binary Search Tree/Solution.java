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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cur = root;
        TreeNode node = new TreeNode(val);
        while (true) {
            if (cur.val == val) {
                return root;
            }

            if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                } else {
                    cur = cur.right;
                }
            } else {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                } else {
                    cur = cur.left;
                }
            }
        }
        return root;
    }
}
