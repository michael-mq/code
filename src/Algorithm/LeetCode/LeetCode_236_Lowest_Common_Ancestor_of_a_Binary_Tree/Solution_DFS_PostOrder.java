package Algorithm.LeetCode.LeetCode_236_Lowest_Common_Ancestor_of_a_Binary_Tree;

/**
 * 返回值： 根据 leftleft 和 rightright ，可展开为四种情况；
 * 1. 当 leftleft 和 rightright 同时为空 ：说明 rootroot 的左 / 右子树中都不包含 p,qp,q ，返回 nullnull ；
 * 2. 当 leftleft 和 rightright 同时不为空 ：说明 p, qp,q 分列在 rootroot 的 异侧 （分别在 左 / 右子树），因此 rootroot 为最近公共祖先，返回 rootroot ；
 * 3. 当 leftleft 为空 ，rightright 不为空 ：p, q 都不在 rootroot 的左子树中，直接返回 rightright 。具体可分为两种情况：
 *      1. p, q 其中一个在 rootroot 的 右子树 中，此时 rightright 指向 p（假设为 p ）；
 *      2. p, q 两节点都在 rootroot 的 右子树 中，此时的 rightright 指向 最近公共祖先节点 ；
 * 4. 当 leftleft 不为空 ， rightright 为空 ：与情况 3. 同理；
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

class Solution_DFS_PostOrder {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) return null; // 1.

        if (left == null) return right; // 3.

        if (right == null) return left; // 4.

        return root; // 2. if(left != null and right != null)
    }
}
