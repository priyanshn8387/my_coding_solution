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
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next==null) return head;

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode dummyTail = dummyHead;

        ListNode curr = head;

        while(curr!=null){

            if(dummyTail.val!=curr.val){
                dummyTail.next = curr;
                dummyTail = curr;
            }

            curr=curr.next;
        }

        dummyTail.next=null;

        return dummyHead.next;
        
    }
}