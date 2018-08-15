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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traversalHelper(root, ret);
        return ret;
    }

    public void traversalHelper(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }

        ret.add(root.val);
        traversalHelper(root.left, ret);
        traversalHelper(root.right, ret);
    }
}
