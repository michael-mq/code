# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        stack = []
        dummy_head = ListNode(next=head)
        curr_node = dummy_head

        while curr_node:
            stack.append(curr_node)
            curr_node = curr_node.next

        node = stack[-1]
        for i in range(n + 1):
            node = stack.pop()

        node.next = node.next.next

        return dummy_head.next
