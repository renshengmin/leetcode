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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    
    public TreeNode buildTreeHelper(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if(inStart > inEnd || postStart < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postStart]);
        int index = 0;
        for(int i=0; i<inorder.length; ++i) {
            if(inorder[i] == postorder[postStart]) {
                index = i;
                break;
            }
        }

        root.left = buildTreeHelper(postStart - (inEnd - index + 1), inStart, index - 1, inorder, postorder);
        root.right = buildTreeHelper(postStart - 1, index + 1, inEnd, inorder, postorder);
        return root;
    }
}
