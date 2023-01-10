package Algorithm.LeetCode.LeetCode_654_Maximum_Binary_Tree;

import java.util.Arrays;

public class Solution_2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int index = findMax(nums);

        TreeNode root = new TreeNode(nums[index]);

        int[] leftNums = Arrays.copyOfRange(nums, 0, index);
        int[] rightNums = Arrays.copyOfRange(nums, index + 1, nums.length);

        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);

        return root;
    }

    private int findMax(int[] nums) {
        int max = -1;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }

        return index;
    }
}
