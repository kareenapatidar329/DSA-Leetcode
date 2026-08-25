/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // Empty / single node / no rotation
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and last node
        int n = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Remove unnecessary full rotations
        k = k % n;

        if (k == 0) {
            return head;
        }

        // Find new tail
        int steps = n - k - 1;

        ListNode newTail = head;

        for (int i = 0; i < steps; i++) {
            newTail = newTail.next;
        }

        // Node after new tail becomes new head
        ListNode newHead = newTail.next;

        // Make list circular
        tail.next = head;

        // Break circle at new tail
        newTail.next = null;

        return newHead;
    }
}