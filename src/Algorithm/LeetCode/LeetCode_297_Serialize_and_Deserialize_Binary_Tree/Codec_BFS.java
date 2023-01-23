package Algorithm.LeetCode.LeetCode_297_Serialize_and_Deserialize_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Codec_BFS {
    // Encodes a tree to a single string.
    String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            /* 层级遍历代码位置 */
            if (cur == null) {
                sb.append("#").append(",");
                continue;
            }
            sb.append(cur.val).append(",");
            /*****************/

            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");
        // 第一个元素就是 root 的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        // 队列 q 记录父节点，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < nodes.length; ) {
            // 队列中存的都是父节点
            TreeNode parent = q.poll();
            // 父节点对应的左侧子节点的值
            String left = nodes[i++];
            if (!left.equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            } else {
                parent.left = null;
            }
            // 父节点对应的右侧子节点的值
            String right = nodes[i++];
            if (!right.equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            } else {
                parent.right = null;
            }
        }

        return root;
    }
}
