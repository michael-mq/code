package Algorithm.LeetCode.LeetCode_501_Find_Mode_in_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

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

class Solution1 {
    int pre = -1000001;
    int count = 1;
    int maxCount = Integer.MIN_VALUE;
    List<Integer> resList = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] res = new int[resList.size()];

        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (root.val == pre) {
            count++;
        } else {
            count = 1;
        }

        if (count == maxCount) {
            resList.add(root.val);
        } else if (count > maxCount) {
            maxCount = count;
            resList.clear();
            resList.add(root.val);
        }

        pre = root.val;

        dfs(root.right);
    }
}