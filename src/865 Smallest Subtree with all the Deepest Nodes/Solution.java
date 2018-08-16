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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        //key curNode value curNode.father
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Set<TreeNode>> traversalRet = new ArrayList<>();

        if (root == null) {
            return root;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            Set<TreeNode> levelRet = new HashSet<>();
            for (int i=0; i<curSize; i++) {
                TreeNode curNode = queue.poll();
                levelRet.add(curNode);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                    fatherMap.put(curNode.left, curNode);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                    fatherMap.put(curNode.right, curNode);
                }
            }
            traversalRet.add(levelRet);
        }

        Set<TreeNode> deepestNodes = traversalRet.get(traversalRet.size() - 1);

        while (deepestNodes.size() != 1) {
            Set<TreeNode> tmp = new HashSet<>();
            for (TreeNode node : deepestNodes) {
                tmp.add(fatherMap.get(node));
            }
            deepestNodes = tmp;
        }
        
        TreeNode ret = null;
        for (TreeNode node : deepestNodes) {
            ret = node;
            break;
        }
        return ret;
    }
}
