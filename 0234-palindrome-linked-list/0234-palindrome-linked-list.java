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
        ListNode curr= head;
        ListNode frwd = curr.next;

        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=frwd;
            if(frwd!=null) frwd=frwd.next;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {


        if(head==null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode interSectionPoint = slow;

        ListNode reverseHead = reverseLL(slow.next);

        ListNode start= head;
        ListNode reverseHeadList = reverseHead;
        boolean found = true;

        while(reverseHeadList!=null){
            if(reverseHeadList.val!=start.val){
                found=false;
                break;
            }
            reverseHeadList=reverseHeadList.next;
            start=start.next;
        }

        // now joining back the list

        reverseLL(reverseHead);

        return found;


        
    }
}