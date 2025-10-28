/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        int lenA = 0;
        int lenB = 0;

        while (a != null) {
            a = a.next;
            lenA++;
        }

        while (b != null) {
            b = b.next;
            lenB++;
        }

        if (lenA >= lenB) {
            int diff = lenA - lenB;
            while (diff > 0 && headA != null) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = lenB - lenA;
            while (diff > 0 && headB != null) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != headB && (headA != null && headB != null)) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}