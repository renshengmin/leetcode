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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        String path = "";
        dfs(ret, path, root);
        return path;
    }

    public void dfs(List<String> ret, String path, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            path += node.val + "";
            ret.add(path);
        }

        if (node.left != null) {
            dfs(ret, path + node.val + "->", node.left);
        }
        if (node.right != null) {
            dfs(ret, path + node.val + "->", node.right);
        }
    }

}
