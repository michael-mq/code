package Algorithm.LeetCode.LeetCode_108_Convert_Sorted_Array_to_Binary_Search_Tree;

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

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = lo + (hi - lo) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);

        return root;
    }
}
