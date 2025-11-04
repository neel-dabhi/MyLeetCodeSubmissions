/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // go over the lists to get head
        // prune the PQ (min)
        // get the min, attech to result
        // put min.next if not null to PQ

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        if (lists.length == 0) {
            return dummy.next;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] !=null ){
                pq.add(lists[i]);
            }
        }

        if (pq.size() == 0) {
            return dummy.next;
        }

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            ListNode next = min.next;

            // append to result
            result.next = min;
            result = result.next;

            // add next pointer to PQ
            if (next != null) {
                pq.add(next);
            }
        }

        return dummy.next;
    }
}