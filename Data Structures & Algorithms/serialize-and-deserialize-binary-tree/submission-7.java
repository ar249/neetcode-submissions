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

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsS(root, sb);
        return sb.toString();
    }

    private void dfsS(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        dfsS(root.left, sb);
        dfsS(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] idx = new int[]{0};
        return dfsD(nodes, idx);
    }

    private TreeNode dfsD(String[] nodes, int[] idx)
    {
        if(idx[0] >= nodes.length || nodes[idx[0]].equals("N"))
        {
            idx[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[idx[0]]));
        idx[0]++;

        node.left = dfsD(nodes, idx);
        node.right = dfsD(nodes, idx);

        return node;
    }
}
