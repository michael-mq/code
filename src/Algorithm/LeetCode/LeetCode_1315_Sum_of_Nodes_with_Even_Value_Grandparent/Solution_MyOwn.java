package Algorithm.LeetCode.LeetCode_1315_Sum_of_Nodes_with_Even_Value_Grandparent;


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
    int res = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, false, false);

        return res;
    }

    void dfs(TreeNode root, boolean parent, boolean grandparent) {
        if (root == null) {
            return;
        }

        if (grandparent) {
            res += root.val;
        }

        dfs(root.left, root.val % 2 == 0, parent);
        dfs(root.right, root.val % 2 == 0, parent);
    }
}