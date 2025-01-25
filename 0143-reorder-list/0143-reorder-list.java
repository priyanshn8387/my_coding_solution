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

    public ListNode reverseLL(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode frwd = curr.next;

        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=frwd;
            if(frwd!=null) frwd = frwd.next;
        }

        return prev;
    }
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode newHead = reverseLL(slow.next);
        slow.next = null;

        ListNode originalHead = head;

        while(newHead!=null){
            
            ListNode originalNext = originalHead.next;
            ListNode newHeadNext = newHead.next;

            originalHead.next = newHead;
            newHead.next = originalNext;


            originalHead = originalNext;
            newHead = newHeadNext;


        }

       
        
    }
}