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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if(cur.right != null && cur.right != pre) {
                //右子树还未访问
                stack.push(cur);
                cur = cur.right;
                continue;
            } else {
                //右子树不存在或者已经访问过了，访问栈顶元素即可
                ret.add(cur.val);
                pre = cur;
                cur = null;
            }

        }
        return ret;
    }
}
