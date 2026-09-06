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

// find mid and separate into 2 diff lists
// reverse second list
// alternate merge nodes from both
class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            if(fast == null || fast.next == null)
            {
                prev.next = null;
            }
        }

        ListNode rh = reverse(slow);

        while(head.next != null && rh != null)
        {
            ListNode t1 = head.next;
            ListNode t2 = rh.next;

            head.next = rh;
            rh.next = t1;

            head = t1;
            rh = t2;
        }

        head.next = rh;
    }

    private ListNode reverse(ListNode slow)
    {
        if(slow == null || slow.next == null)
        {
            return slow;
        }

        ListNode prev = null;
        ListNode cur = slow;

        while(cur!= null)
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    } 
}
