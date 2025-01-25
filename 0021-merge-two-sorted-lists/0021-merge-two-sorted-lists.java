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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTail = dummyHead;

        ListNode head1 = list1;
        ListNode head2 = list2;

        while(list1!=null&& list2!=null){

            if(list1.val==list2.val){
                dummyTail.next=list1;
                dummyTail=list1;

                list1= list1.next;

            }else if(list1.val>list2.val){
                dummyTail.next=list2;
                dummyTail=list2;

                list2 =list2.next;
            }else{
                dummyTail.next=list1;
                dummyTail=list1;

                list1 =list1.next;

            }
        }

        if(list1!=null){
            dummyTail.next=list1;
            dummyTail=list1;
        }

        if(list2!=null){
            dummyTail.next=list2;
            dummyTail=list2;
        }

        return dummyHead.next;
        
    }
}