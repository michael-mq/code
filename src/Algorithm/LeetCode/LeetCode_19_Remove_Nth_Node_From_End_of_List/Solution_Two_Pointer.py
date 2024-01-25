# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy_head = ListNode(next=head)
        pointer_1 = dummy_head
        pointer_2 = dummy_head

        for i in range(n):
            pointer_2 = pointer_2.next

        while pointer_2.next:
            pointer_1 = pointer_1.next
            pointer_2 = pointer_2.next

        pointer_1.next = pointer_1.next.next

        return dummy_head.next
