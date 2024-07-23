class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null) {
            while(curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            prev.next = curr;
            prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}