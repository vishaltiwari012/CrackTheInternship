class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            return null;
        }
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }
        if(n == size) {
            return head.next;
        }

        int indexToSearch = size - n;
        ListNode temp = head;
        int i = 1;
        while(i < indexToSearch) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }
}