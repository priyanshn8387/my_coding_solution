/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head==null || head.next==null) return null;
        ListNode slow=head;
        ListNode fast = head;

        ListNode interSection = null;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                interSection=slow;
                break;
            }
        }

        if(interSection == null) return null;

        ListNode start = head;
       
        while(start!=interSection){
            start=start.next;
            interSection=interSection.next;
        }

        return start;

        
    }
}