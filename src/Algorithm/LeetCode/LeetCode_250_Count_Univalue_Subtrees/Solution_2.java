package Algorithm.LeetCode.LeetCode_250_Count_Univalue_Subtrees;

public class Solution_2 {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        is_valid_part(root, 0);

        return count;
    }

    boolean is_valid_part(TreeNode node, int val) {

        // considered a valid subtree
        if (node == null)
            return true;

        // check if node.left and node.right are univalue subtrees of value node.val
        // note that || short circuits but | does not - both sides of the or get evaluated with | so we explore all possible routes
        if (!is_valid_part(node.left, node.val) | !is_valid_part(node.right, node.val))
            return false;

        // if it passed the last step then this a valid subtree - increment
        count++;

        // at this point we know that this node is a univalue subtree of value node.val
        // pass a boolean indicating if this is a valid subtree for the parent node
        return node.val == val;
    }


}
