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
    int preOrder = 0;
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i =0; i<inorder.length; i++)
        {
           inMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right)
    {
        if(left > right)
        {
            return null;
        }

        int val = preorder[preOrder++];
        TreeNode root = new TreeNode(val);

        int id = inMap.get(val);
        
        root.left = buildTree(preorder, left, id-1);
        root.right = buildTree(preorder, id+1, right);

        return root;
    }
}
