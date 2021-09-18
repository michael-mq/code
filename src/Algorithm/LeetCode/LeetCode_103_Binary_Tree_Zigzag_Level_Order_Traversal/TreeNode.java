package Algorithm.LeetCode.LeetCode_103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution_MyOwn {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<TreeNode>> resRaw = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            resRaw.add(list);
        }

        boolean leftToRight = false;

        for (List<TreeNode> list : resRaw) {
            List<Integer> temp = new ArrayList<>();

            for (TreeNode node : list) {
                if (leftToRight) {
                    temp.add(0, node.val);
                } else {
                    temp.add(node.val);
                }
            }

            res.add(temp);
            leftToRight = !leftToRight;
        }

        return res;
    }
}
