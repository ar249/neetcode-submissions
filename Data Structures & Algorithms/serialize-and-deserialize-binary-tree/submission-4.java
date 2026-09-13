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
        dfsSer(root, sb);
        return sb.toString();
    }

    private void dfsSer(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        dfsSer(root.left, sb);
        dfsSer(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        int[] idx = new int[]{0};
        return dfsDeSer(d, idx);
    }

    private TreeNode dfsDeSer(String[] data, int[] idx)
    {
        if(idx[0] >= data.length || data[idx[0]].equals("N"))
        {
            idx[0]++;
            return null;
        }

        TreeNode parent = new TreeNode(Integer.parseInt(data[idx[0]]));

        idx[0]++;

        parent.left = dfsDeSer(data, idx);
        parent.right = dfsDeSer(data, idx);

        return parent;
    }
}
