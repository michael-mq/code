package Algorithm.LeetCode.LeetCode_297_Serialize_and_Deserialize_Binary_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }

        /****** 前序遍历位置 ******/
        sb.append(root.val).append(",");
        /***********************/

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new ArrayList<>(Arrays.asList(data.split(",")));

        return deserialize(nodes);
    }

    private TreeNode deserialize(List<String> nodes) {
        if (nodes.isEmpty())
            return null;

        /****** 前序遍历位置 ******/
        // 列表最左侧就是根节点
        String val = nodes.remove(0);

        if (val.equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        /***********************/

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
