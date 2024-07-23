class Solution {
    public Node copyRandomList(Node head) {

        // Copy Node in between
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // Copy randome pointer of original node to copied node
        temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            } else {
                temp.next.random = null;
            }
            temp = temp.next.next;
        }

        // Now connect all copied nodes and return head
        Node dummy = new Node(-1);
        temp = head;
        Node itr = dummy;
        Node fast;

        while(temp != null) {
            fast = temp.next.next;
            itr.next = temp.next;
            temp.next = fast;
            itr = itr.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}