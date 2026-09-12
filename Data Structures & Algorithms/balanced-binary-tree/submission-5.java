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

    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        check(root);
        return balanced;
    }

    private int check(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int l = check(root.left);
        int r = check(root.right);

        if(Math.abs(l-r) > 1)
        {
            balanced = false;
            return 0;
        }

        return Math.max(l, r) + 1;
    }
}
