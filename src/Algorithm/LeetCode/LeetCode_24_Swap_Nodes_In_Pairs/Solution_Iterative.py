# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy_head = ListNode()
        dummy_head.next = head
        pre = dummy_head

        while head and head.next:
            cur = head
            tmp = head.next

            cur.next = tmp.next
            pre.next = tmp
            tmp.next = cur

            pre = cur
            head = cur.next

        return dummy_head.next
