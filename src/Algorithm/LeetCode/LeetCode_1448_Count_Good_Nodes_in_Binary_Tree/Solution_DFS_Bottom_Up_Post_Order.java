package Algorithm.LeetCode.LeetCode_1448_Count_Good_Nodes_in_Binary_Tree;

//https://youtu.be/WzsunIWpXJg?si=1W4XWmyPG5c3rVhf&t=6341
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

class Solution_DFS_Bottom_Up_Post_Order {
    public int goodNodes(TreeNode root) {
        return dfs(root, -10000);
    }

    int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int res = 0;

        if (root.val >= max) {
            max = root.val;
            res++;
        }

        int left = dfs(root.left, max);
        int right = dfs(root.right, max);

        return res + left + right;
    }
}