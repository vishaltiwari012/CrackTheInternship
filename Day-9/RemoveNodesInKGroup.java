class Solution {
    public int findLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode curr, nex;
        int length = findLength(head);

        while(length >= k) {
            curr = pre.next;
            nex = curr.next;

            for(int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }

            pre = curr;
            length -= k;
        }

        return dummy.next;
    }
}