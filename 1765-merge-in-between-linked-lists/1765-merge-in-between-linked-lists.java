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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        ListNode current = list1;  
        ListNode aNode = null;
        ListNode bNode = null;    
        
        while(current.next !=null){
        
            if (count == (a-1)){
               aNode= current;
            }
            if(count == b){
                bNode = current.next;
                break;
            }
            current = current.next;
            count++;
        }
        
        aNode.next = list2;
        current = list2;
        while(current.next!=null){
            current = current.next;
        }
        
        current.next = bNode;
        
        return list1;
        
    }
}