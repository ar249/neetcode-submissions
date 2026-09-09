/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxDiameter;
    }

    private int getHeight(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int l = getHeight(node.left);
        int r = getHeight(node.right);

        maxDiameter = Math.max(maxDiameter, l+r);

        return Math.max(l, r) + 1;
    }
}
