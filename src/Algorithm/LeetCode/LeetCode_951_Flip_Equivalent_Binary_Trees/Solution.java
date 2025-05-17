package Algorithm.LeetCode.LeetCode_951_Flip_Equivalent_Binary_Trees;

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

//https://leetcode.com/problems/flip-equivalent-binary-trees/editorial

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        // Check if corresponding subtrees are flip equivalent
        boolean noSwap =
                flipEquiv(root1.left, root2.left) &&
                        flipEquiv(root1.right, root2.right);
        // Check if opposite subtrees are flip equivalent
        boolean swap =
                flipEquiv(root1.left, root2.right) &&
                        flipEquiv(root1.right, root2.left);

        return noSwap || swap;
    }
}