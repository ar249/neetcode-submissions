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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        serialize(root, sb1);
        serialize(subRoot, sb2);

        return sb1.toString().contains(sb2.toString());
    }


    private void serialize(TreeNode node, StringBuilder sb)
    {
        if(node == null){
          sb.append("#");
          return;
        } 

        sb.append(node.val);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
}
