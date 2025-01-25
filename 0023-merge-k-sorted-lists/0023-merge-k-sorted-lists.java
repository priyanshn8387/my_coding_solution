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

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);

        for(ListNode list : lists){
            if(list!=null){
                pq.offer(list);
            }
        }

        ListNode newHead = new ListNode(-1);
        ListNode newTail=newHead;

        while(!pq.isEmpty()){
            ListNode temp  = pq.poll();
            newTail.next = temp;
            newTail = temp;

            if(temp.next!=null){
                pq.offer(temp.next);
            }
        }

        return newHead.next;
        
    }
}