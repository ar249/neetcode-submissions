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
    Map<Integer, Integer> map = new HashMap<>();
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length; i++)
        {
            map.put(inorder[i], i);
        }

        return getRoot(preorder, 0, inorder.length-1);
    }

    private TreeNode getRoot(int[] preorder, int left, int right)
    {
        if(left > right)
        {
            return null;
        }

        int val = preorder[preIdx++];
        TreeNode root = new TreeNode(val);

        int id = map.get(val);

        root.left = getRoot(preorder, left, id-1);
        root.right = getRoot(preorder, id+1, right);

        return root;
    }
}
