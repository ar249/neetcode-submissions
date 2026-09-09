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

    private int getHeight(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int l = getHeight(root.left);
        int r = getHeight(root.right);

        maxDiameter = Math.max(maxDiameter, l+r);

        return Math.max(l, r) + 1;
    }
}
