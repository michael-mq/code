package Algorithm.LeetCode.LeetCode_538_Convert_BST_to_Greater_Tree;

//https://www.programmercarl.com/0538.把二叉搜索树转换为累加树.html
public class Solution_Recursion {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
       if (root != null) {
           convertBST(root.right);
           sum += root.val;
           root.val = sum;
           convertBST(root.left);
       }

       return root;
    }

    public static void main(String[] args) {
        Solution_Recursion solutionIteration = new Solution_Recursion();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        TreeNode foo = solutionIteration.convertBST(root);

        root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);

        TreeNode bar = solutionIteration.convertBST(root);
    }
}
