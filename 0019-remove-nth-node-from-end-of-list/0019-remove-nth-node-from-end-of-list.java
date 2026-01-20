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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode fast = head;
        int count =0;

        while(fast!=null && count!=n){
            fast=fast.next;
            count++;
        }

     // CASE 1: removing head
        if (fast == null) {
            return head.next;
        }

        ListNode slow = head;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}