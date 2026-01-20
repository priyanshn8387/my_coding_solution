class Solution {

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTail = dummyHead;

        ListNode curr = head;

        while (curr != null) {

            // 1️⃣ check if k nodes exist
            ListNode temp = curr;
            int count = 0;
            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }

            // fewer than k → append remainder and finish
            if (count < k) {
                dummyTail.next = curr;
                break;
            }

            // 2️⃣ cut k nodes
            ListNode groupHead = curr; // will become tail after reverse
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }

            // prev is kth node
            prev.next = null; // CUT

            // 3️⃣ reverse cut group
            ListNode newHead = reverse(groupHead);

            // 4️⃣ append reversed group
            dummyTail.next = newHead;

            // 5️⃣ move dummyTail to end of reversed group
            dummyTail = groupHead;
        }

        return dummyHead.next;
    }
}
