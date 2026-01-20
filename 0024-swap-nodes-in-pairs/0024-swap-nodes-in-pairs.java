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

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTail = dummyHead;

        int k = 2;
        ListNode curr = head;

        while (curr != null) {

            // 1️⃣ check if 2 nodes exist
            ListNode temp = curr;
            int count = 0;
            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }

            // less than 2 nodes → append remaining
            if (count < k) {
                dummyTail.next = curr;
                break;
            }

            // 2️⃣ cut 2 nodes
            ListNode groupHead = curr;
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }

            // prev is second node
            prev.next = null; // CUT

            // 3️⃣ reverse the pair
            ListNode newHead = reverse(groupHead);

            // 4️⃣ append reversed pair
            dummyTail.next = newHead;

            // 5️⃣ move dummyTail to end of reversed pair
            dummyTail = groupHead;
        }

        return dummyHead.next;
    }
}
