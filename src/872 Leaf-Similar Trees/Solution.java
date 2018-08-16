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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ret1 = new ArrayList<>();
        List<Integer> ret2 = new ArrayList<>();
        preOrderTraverse(root1, ret1);
        preOrderTraverse(root2, ret2);

        return ret1.equals(ret2);
    }

    public void preOrderTraverse(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ret.add(root.val);
        }
        preOrderTraverse(root.left, ret);
        preOrderTraverse(root.right, ret);
    }
}
