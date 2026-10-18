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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
        {
            return List.of();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> ls = new ArrayList<>();

            for(int i = 0; i<size; i++)
            {
                TreeNode ts = q.poll();
                ls.add(ts.val);

                if(ts.left != null)
                {
                    q.offer(ts.left);
                }

                if(ts.right != null)
                {
                    q.offer(ts.right);
                }
            }
            res.add(ls);
        }

        return res;
    }
}
