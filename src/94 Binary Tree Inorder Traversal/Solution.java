/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//递归的解法
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traversalHelper(root, ret);
        return ret;   
    }

    public void traversalHelper(TreeNode root, List<Integer> ret) {
        if(root == null) {
            return;
        }
        traversalHelper(root.left, ret);
        ret.add(root.val);
        traversalHelper(root.right, ret);
    }
}
