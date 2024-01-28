# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# https://www.programmercarl.com/面试题02.07.链表相交.html
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA, lenB = 0, 0

        cur = headA
        while cur:
            cur = cur.next
            lenA += 1

        cur = headB
        while cur:
            cur = cur.next
            lenB += 1

        curA, curB = headA, headB

        if lenB > lenA:
            lenA, lenB = lenB, lenA
            curA, curB = headB, headA

        for _ in range(lenA - lenB):
            curA = curA.next

        while curA != curB:
            curA = curA.next
            curB = curB.next

        return curA if curA else None
