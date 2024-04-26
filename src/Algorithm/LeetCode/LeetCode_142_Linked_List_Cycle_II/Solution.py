# Definition for singly-linked list.
from typing import Optional


# https://www.programmercarl.com/0142.环形链表II.html
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast = head
        slow = head

        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

            if fast == slow:
                slow = head

                while slow != fast:
                    slow = slow.next
                    fast = fast.next

                return slow

        return