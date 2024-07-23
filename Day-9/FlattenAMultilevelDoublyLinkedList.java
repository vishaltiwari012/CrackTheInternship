class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                Node child = curr.child;
                curr.next = child;
                child.prev = curr;
                curr.child = null;

                while (child.next != null) {
                    child = child.next;
                }

                if (next != null) {
                    child.next = next;
                    next.prev = child;
                }
            }
            curr = curr.next;
        }

        return head;
    }
}