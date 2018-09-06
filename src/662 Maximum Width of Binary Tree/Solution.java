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
    int ret;
    Map<Integer, Integer> depthLeft;
    
    public int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        ret = 1;
        depthLeft = new HashMap<>();
        dfs(root, 1, 1);
        return ret;
    }

    public void dfs(TreeNode node, int depth, int idx) {
        if (null == node) {
            return;
        }

        if (!depthLeft.containsKey(depth)) {
            depthLeft.put(depth, idx);
        } else {
            ret = Math.max(ret, idx - depthLeft.get(depth) + 1);
        }
        dfs(node.left, depth + 1, 2 * idx);
        dfs(node.right, depth + 1, 2 * idx + 1);

    }
}
