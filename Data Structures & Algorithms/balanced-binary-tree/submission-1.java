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
         isCorrect(root);
         return balanced;
    }

    private int isCorrect(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int l = isCorrect(node.left);
        int r = isCorrect(node.right);

        if(Math.abs(l-r) > 1)
        {
            balanced = false;
        }

        return Math.max(l, r) + 1;
    }
}
