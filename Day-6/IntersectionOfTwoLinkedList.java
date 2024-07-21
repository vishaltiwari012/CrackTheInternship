public class Solution {
    public int getLength(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode tempA = headA;
        ListNode tempB = headB;

        if(lenA > lenB) {
            int steps = lenA - lenB;
            for(int i = 1; i <= steps; i++) {
                tempA = tempA.next;
            }
        } else {
            int steps = lenB - lenA;
            for(int i = 1; i <= steps; i++) {
                tempB = tempB.next;
            }
        }

        while(tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }
}