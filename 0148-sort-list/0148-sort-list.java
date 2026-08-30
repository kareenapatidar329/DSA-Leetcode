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
    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split into two lists
        ListNode second = slow.next;
        slow.next = null;

        // Sort both halves
        ListNode first = sortList(head);
        second = sortList(second);

        // Merge two sorted lists
        return merge(first, second);
    }

    private ListNode merge(ListNode first, ListNode second) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (first != null && second != null) {

            if (first.val <= second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }

            curr = curr.next;
        }

        if (first != null) {
            curr.next = first;
        }

        if (second != null) {
            curr.next = second;
        }

        return dummy.next;
    }
}