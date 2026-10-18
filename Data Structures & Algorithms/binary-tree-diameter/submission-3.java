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
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        check(root);
        return res;
    }

    private int check(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int ls = check(root.left);
        int rs = check(root.right);

        res = Math.max(res, ls+rs);

        return Math.max(ls, rs) + 1;
    }
}
