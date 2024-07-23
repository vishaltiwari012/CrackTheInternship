class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        ListNode nex = curr.next;
        for(int i = 0; i < right - left; i++) {
            curr.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
            nex = curr.next;
        }

        return dummy.next;
    }
}