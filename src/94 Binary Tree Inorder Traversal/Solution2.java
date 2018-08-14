/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p  != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                ret.add(p.val);
                p = p.right;
            }
        }
        return ret;
    }
}
