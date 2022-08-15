package Algorithm.LeetCode.LeetCode_2096_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another;


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

// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/discuss/1612105/3-Steps/1170950
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();

        find(root, startValue, start);
        find(root, destValue, dest);

        start.reverse();
        dest.reverse();

        while (start.length() > 0 && dest.length() > 0 && start.charAt(0) == dest.charAt(0)) {
            start.deleteCharAt(0);
            dest.deleteCharAt(0);
        }

        return "U".repeat(start.length()) + dest.toString();

    }

    private boolean find(TreeNode root, int val, StringBuilder sb) {
        if (root.val == val)
            return true;

        if (root.left != null && find(root.left, val, sb)) {
            sb.append("L");
            return true;
        }

        if (root.right != null && find(root.right, val, sb)) {
            sb.append("R");
            return true;
        }

        return false;
    }
}