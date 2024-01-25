# Definition for singly-linked list.
from typing import Optional


# https://www.programmercarl.com/0206.翻转链表.html
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        cur = self.reverseList(head.next)
        head.next.next = head
        head.next = None

        return cur

    def reverse(self, cur: Optional[ListNode], pre: Optional[ListNode]) -> Optional[ListNode]:
        if not cur:
            return pre

        tmp = cur.next
        cur.next = pre

        return self.reverse(tmp, cur)
