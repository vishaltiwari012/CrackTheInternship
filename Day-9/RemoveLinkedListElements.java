class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while(temp.next != null) {
            if(temp.next.val != val) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        return dummy.next;
    }
}