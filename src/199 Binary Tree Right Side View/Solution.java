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
  public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (null == root) {
            return ret;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int curLevel = q.size();
            TreeNode curNode;
            for (int i = 0; i < curLevel; ++i) {
                curNode = q.poll();
                if (curNode.left != null) {
                    q.offer(curNode.left);
                }
                if (curNode.right != null) {
                    q.offer(curNode.right);
                }
            }
            ret.add(curNode.val);
        }
        return ret;
    }
}
