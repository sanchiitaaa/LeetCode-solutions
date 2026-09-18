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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sHalf = reverse(slow.next);
        ListNode fHalf = head;
        slow.next = null;
        while(sHalf != null)
        {
            ListNode temp1 = fHalf.next;
            ListNode temp2 = sHalf.next;
            fHalf.next = sHalf;
            sHalf.next = temp1;
            fHalf = temp1;
            sHalf = temp2;
        }
    }
    private ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}