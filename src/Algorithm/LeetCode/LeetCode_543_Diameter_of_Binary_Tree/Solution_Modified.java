package Algorithm.LeetCode.LeetCode_543_Diameter_of_Binary_Tree;

class Solution_Modified {
    public int diameterOfBinaryTree(TreeNode root) {
        // Why make ans as an array?
        // because array is by reference while int is by value
        // and we need to pass down ans to recursion so reference will always point to same variable
        int[] ans = new int[]{1};
        depth(ans, root);
        return ans[0] - 1;
    }

    public int depth(int[] ans, TreeNode node) {
        if (node == null) return 0; // 访问到空节点了，返回0
        int L = depth(ans, node.left); // 左儿子为根的子树的深度
        int R = depth(ans, node.right); // 右儿子为根的子树的深度
        ans[0] = Math.max(ans[0], L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    public static void main(String[] args) {
        Solution_Modified solutionModified = new Solution_Modified();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(solutionModified.diameterOfBinaryTree(root));
    }
}
