//package Algorithm.LeetCode.LeetCode_865_1123_Smallest_Subtree_with_all_the_Deepest_Nodes;
//
//// https://www.youtube.com/watch?v=q1zk8vZIDw0
//class Solution {
//    public TreeNode subtreeWithAllDeepest(TreeNode root) {
//        return helper(root).getValue();
//    }
//
//    private Pair<Integer, TreeNode> helper(TreeNode node) {
//        if (node.left == null && node.right == null) {
//            return new Pair<>(0, node);
//        }
//
//        Pair<Integer, TreeNode> left = new Pair<>(-1, null);
//        Pair<Integer, TreeNode> right = new Pair<>(-1, null);
//
//        if (node.left != null) {
//            left = helper(node.left);
//        }
//
//        if (node.right != null) {
//            right = helper(node.right);
//        }
//
//        if (left.getKey() == right.getKey()) {
//            return new Pair<>(left.getKey() + 1, node);
//        } else if (left.getKey() > right.getKey()){
//            return new Pair<>(left.getKey() + 1, left.getValue());
//        } else {
//            return new Pair<>(right.getKey() + 1, right.getValue());
//        }
//    }
//}
