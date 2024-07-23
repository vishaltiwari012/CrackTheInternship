class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;

        while(fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;

        ListNode first = sortList(head);
        ListNode second = sortList(slow);

        return merge(first, second);
    }

    public ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode c1 = first;
        ListNode c2 = second;

        while(c1 != null && c2 != null) {
            if(c1.val < c2.val) {
                curr.next = c1;
                c1 = c1.next;
            } else {
                curr.next = c2;
                c2 = c2.next;
            }
            curr = curr.next;
        }

        if(c1 != null) {
            curr.next = c1;
        }
        if(c2 != null) {
            curr.next = c2;
        }

        return dummy.next;
    }
}