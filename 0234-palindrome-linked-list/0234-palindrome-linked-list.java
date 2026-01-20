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

    public ListNode reverse(ListNode head){

        if(head==null || head.next==null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode frwd = curr.next;

        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=frwd;
            if(frwd!=null)frwd=frwd.next;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){ // IMP
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode mid = slow;
        ListNode revHead = reverse(slow.next);
        
        ListNode start = head;
        ListNode end = revHead;
       

        while(end!=null){
            if(start.val!=end.val){
                reverse(revHead);
                return false;
            }
            start= start.next;
            end = end.next;
        }

        // Now Joining back
        reverse(revHead);
       



        return true;

        
    }
}