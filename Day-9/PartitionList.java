class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(-1);
        ListNode after = new ListNode(-1);
        ListNode t1 = before, t2 = after;

        while(head != null) {
            if(head.val < x) {
                t1.next = head;
                t1 = t1.next;
            } else {
                t2.next = head;
                t2 = t2.next;
            } 
            head = head.next;
        }

        t2.next = null;
        t1.next = after.next;
        return before.next;
    }
}