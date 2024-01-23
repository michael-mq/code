# Definition for singly-linked list.
from typing import Optional


# https://www.programmercarl.com/0203.移除链表元素.html
class ListNode:
    def __int__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        if not head:
            return None

        head.next = self.removeElements(head.next, val)

        return head.next if head.val == val else head
