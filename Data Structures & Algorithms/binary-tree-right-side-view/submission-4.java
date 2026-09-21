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
        List<Integer> res = new ArrayList<>();
         getView(root, 0, res);
         return res;
    }

    private void getView(TreeNode node, int d, List<Integer> res)
    {
        if(node == null)
        {
            return;
        }

        if(d == res.size())
        {
            res.add(node.val);
        }

        getView(node.right, d+1, res);
        getView(node.left, d+1, res);
    }
}
