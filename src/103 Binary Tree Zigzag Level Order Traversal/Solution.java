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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean reverseFlag = false;
        if (root == null) {
            return ret;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> levelRet = new ArrayList<>();
            for (int i = 0; i < levelNum; ++i) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }

                if(reverseFlag) {
                    levelRet.add(0, curNode.val);
                }else{
                    levelRet.add(curNode.val);
                }
            }
            ret.add(levelRet);
            reverseFlag = !reverseFlag;
        }
        return ret;
    }
}
