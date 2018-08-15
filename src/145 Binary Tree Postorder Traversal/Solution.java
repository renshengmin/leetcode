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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traversalHelper(root, ret);
        return ret;
    }

    public void traversalHelper(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }

        traversalHelper(root.left, ret);
        traversalHelper(root.right, ret);
        ret.add(root.val);
    }
}
