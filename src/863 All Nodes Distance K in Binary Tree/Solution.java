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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ret = new ArrayList<>();
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(root, null, fatherMap);
        bfs(target, K, ret, fatherMap, visited);
        return ret;
    }

    public void dfs(TreeNode root, TreeNode pre, Map<TreeNode, TreeNode> fatherMap) {
        if(root == null) {
            return;
        }
        fatherMap.put(root, pre);
        dfs(root.left, root, fatherMap);
        dfs(root.right, root, fatherMap);
    }

    public void bfs(TreeNode target, int k, List<Integer> ret, Map<TreeNode, TreeNode> fatherMap, Set<TreeNode> visited) {
        if(target == null) {
            return;
        }
        if(visited.contains(target)) {
            return;
        }
        visited.add(target);
        if(k == 0) {
            ret.add(target.val);
            return;
        }
        bfs(target.left, k-1, ret, fatherMap, visited);
        bfs(target.right, k-1, ret, fatherMap, visited);
        bfs(fatherMap.get(target), k-1, ret, fatherMap, visited);
    }
}
