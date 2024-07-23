class Solution {
    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null) {
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }

    private void merge(ListNode firstHead, ListNode secondHead) {
        ListNode t1 = firstHead;
        ListNode t2 = secondHead;

        while(t1 != null && t2 != null) {
            ListNode firstNext = t1.next;
            t1.next = t2;
            ListNode secondNext = t2.next;
            t2.next = firstNext;

            t1 = firstNext;
            t2 = secondNext;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode firstHead = findMiddleNode(head);
        ListNode secondHead = reverse(firstHead.next);
        firstHead.next = null;
        merge(head, secondHead);
    }
}