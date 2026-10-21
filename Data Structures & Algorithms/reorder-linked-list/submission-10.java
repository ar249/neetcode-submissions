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
        if(head.next == null)
        {
            return;
        }
        ListNode temp = head;
        ListNode fast = temp;
        ListNode slow = temp;
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

        ListNode rh = rev(slow);


        ListNode tem = head;
        while(tem.next != null && rh != null)
        {
            ListNode t1 = tem.next;
            ListNode t2 = rh.next;

            tem.next = rh;
            rh.next = t1;
            
            tem = t1;
            rh = t2;
        }

        tem.next = rh;
    }

    private ListNode rev(ListNode head)
    {
        if(head == null)
        {
            return null;
        }

        ListNode prev = null;
        ListNode cur = head;

        while(cur != null)
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
}
