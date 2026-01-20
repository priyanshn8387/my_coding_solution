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
    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next == null ) return head;

        ListNode evenHead = new ListNode(-1,null);
        ListNode evenTail = evenHead;
        ListNode oddHead = new ListNode(-1,null);
        ListNode oddTail = oddHead;

        ListNode curr = head;
        int count =1;
        while(curr!=null){
            if((count%2)!=0){ // odd
                oddTail.next = curr;
                oddTail=oddTail.next;
               
            }else{
                evenTail.next = curr;
                evenTail=evenTail.next;
               
            }
            curr= curr.next;
            count++;
        }

        evenTail.next=null;

        oddTail.next=evenHead.next;

        return oddHead.next;

        
    }
}