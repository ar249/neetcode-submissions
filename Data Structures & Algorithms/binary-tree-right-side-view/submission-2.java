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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        dfs(root, 0, ls);
        return ls;
    }

    private void dfs(TreeNode root, int d, List<Integer> ls)
    {
        if(root == null)
        {
            return;
        }

        if(ls.size() == d)
        {
            ls.add(root.val);
        }

        dfs(root.right, d+1, ls);
        dfs(root.left, d+1, ls);
    }
}
