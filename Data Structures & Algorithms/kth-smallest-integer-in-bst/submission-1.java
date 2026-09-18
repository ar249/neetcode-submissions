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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;

        while(temp != null || !st.isEmpty())
        {
            while(temp != null)
            {
                st.push(temp);
                temp = temp.left;
            }

            TreeNode tmp = st.pop();
            k--;

            if(k == 0)
            {
                return tmp.val;
            }

            temp = tmp.right;
        }

        return -1;
    }
}
