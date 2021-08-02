package Algorithm.Others.BinaryTree;

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


public class BST {
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    boolean isInTree(TreeNode root, int target) {
        if (root == null)
            return false;

        if (root.val == target)
            return true;

        return isInTree(root.left, target) || isInTree(root.right, target);
    }

    boolean isInBST(TreeNode root, int target) {
        if (root == null)
            return false;

        if (root.val == target) {
            return true;
        } else if (root.val < target) {
            return isInBST(root.right, target);
        } else
            return isInBST(root.left, target);
    }

    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root.val == val)
            return new TreeNode(val);

        if (root.val < val)
            root.right = insertIntoBST(root.right, val);

        if (root.val > val)
            root.left = insertIntoBST(root.left, val);

        return root;
    }
}
