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
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            if (fast == null || fast.next == null) {
                prev.next = null;
            }
        }

        ListNode reverseHead = reverse(slow);

        while (head.next != null && reverseHead != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = reverseHead.next;

            head.next = reverseHead;
            reverseHead.next = tmp1;

            head = tmp1;
            reverseHead = tmp2;
        }

        head.next = reverseHead;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
}
