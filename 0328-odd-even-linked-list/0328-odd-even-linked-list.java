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

        ListNode evenHead = new ListNode(-1);
        ListNode oddHead = new ListNode(-1);

        ListNode evenTail = evenHead;
        ListNode oddTail = oddHead;

        ListNode curr = head;
        int count=1;
        while(curr!=null){
            if((count)%2==0){
                evenTail.next=curr;
                evenTail=curr;

            }else{
                oddTail.next=curr;
                oddTail=curr;
            }

            curr=curr.next;
            count++;
        }

        evenTail.next = null; // Terminate the even list
        oddTail.next=evenHead.next;

        return oddHead.next;
        
    }
}