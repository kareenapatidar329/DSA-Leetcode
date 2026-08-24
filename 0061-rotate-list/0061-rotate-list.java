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
 //tc = O(n) //sc = O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null  || k==0){
            return head;
        }
        //length + tail ?
        int n = 1;
        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            n++;
        }
         k = k % n;
         if(k==0){
            return head;
         }
         //new tail find
         int steps = n-k-1;
         ListNode newTail = head;
         for(int i=0; i<steps; i++){
            newTail = newTail.next;
         }
         ListNode newHead = newTail.next;
         tail.next = head;
         newTail.next = null;
         return newHead;
    }
}