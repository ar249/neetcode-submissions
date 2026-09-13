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
    int maxRes = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxRes;
    }

    private int dfs(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int ls = Math.max(0, dfs(node.left));
        int rs = Math.max(0, dfs(node.right));

        maxRes = Math.max(maxRes, ls + rs + node.val);

        return Math.max(ls, rs) + node.val;
    }
}
