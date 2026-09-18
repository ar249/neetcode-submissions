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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        check(root);
        return isBalanced;
    }

    private int check(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int ls = check(root.left);
        int rs = check(root.right);

        if(Math.abs(ls-rs) > 1)
        {
            isBalanced = false;
            return 0;
        }

        return Math.max(ls, rs) + 1;
    }
}
