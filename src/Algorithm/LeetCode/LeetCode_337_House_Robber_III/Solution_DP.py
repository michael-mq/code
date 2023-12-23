# Definition for a binary tree node.
from typing import Optional

# https://www.programmercarl.com/0337.打家劫舍III.html
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        res = self.__rob_action(root)

        return max(res[0], res[1])

    def __rob_action(self, root: Optional[TreeNode]):
        if not root:
            return 0, 0

        left = self.__rob_action(root.left)
        right = self.__rob_action(root.right)

        val_0 = max(left[0], left[1]) + max(right[0], right[1])
        val_1 = root.val + left[0] + right[1]

        return val_0, val_1
