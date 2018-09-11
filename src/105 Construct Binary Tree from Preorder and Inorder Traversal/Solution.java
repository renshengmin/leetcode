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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int curRootIdx, int[] inorder, int inStart, int inEnd) {
        if (curRootIdx > preorder.length - 1 || inStart > inEnd) {
            return null;
        }   

        TreeNode root = new TreeNode(preorder[curRootIdx]);
        int index = 0;
        for (int i=inStart; i<=inEnd; i++) {
            if (inorder[i] == preorder[curRootIdx]) {
                index = i;
                break;
            }
        }
        root.left = buildTreeHelper(preorder, curRootIdx + 1, inorder, inStart, index - 1);
        root.right = buildTreeHelper(preorder, curRootIdx + index - inStart + 1, inorder, index + 1, inEnd);
        return root;
    }
}
