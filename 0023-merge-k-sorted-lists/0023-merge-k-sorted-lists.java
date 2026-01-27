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
        int k = lists.length;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

         // Add head of each list
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTail = dummyHead;

        while(!pq.isEmpty()){
            ListNode current = pq.poll();

            dummyTail.next = current;
            dummyTail = current;

            if(current.next!=null) pq.offer(current.next);
        }


        return dummyHead.next;





    }
}