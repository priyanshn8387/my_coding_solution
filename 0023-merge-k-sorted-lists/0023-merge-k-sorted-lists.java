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

    public void appendLL(ListNode head, PriorityQueue<Integer> pq){
       

        while(head!=null){
            pq.offer(head.val);
            head=head.next;
        }


    }
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode list : lists){
            appendLL(list,pq);
        }

        ListNode newHead = new ListNode(-1);
        ListNode newTail=newHead;

        while(!pq.isEmpty()){
            ListNode temp  = new ListNode(pq.poll());
            newTail.next = temp;
            newTail = temp;
        }

        return newHead.next;
        
    }
}