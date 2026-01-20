class Solution {

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPrev = dummy;
        ListNode curr = head;
        int count = 1;

        // reach leftPrev
        while (count < left) {
            leftPrev = curr;
            curr = curr.next;
            count++;
        }

        ListNode leftNode = curr;

        // reach right node
        while (count < right) {
            curr = curr.next;
            count++;
        }

        ListNode rightNode = curr;
        ListNode rightNext = rightNode.next;

        // cut
        leftPrev.next = null;
        rightNode.next = null;

        // reverse middle
        ListNode newHead = reverse(leftNode);

        // reconnect
        leftPrev.next = newHead;
        leftNode.next = rightNext;

        return dummy.next;
    }
}
