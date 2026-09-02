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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null || k == 1)
        {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;

        while(true)
        {
            ListNode kth = getKth(prevNode, k);

            if(kth == null)
            {
                break;
            }

            ListNode nxtNode = kth.next;

            kth.next = null;

            // ListNode revHead = rev(prevNode);

            ListNode prev = prevNode;
            ListNode curr = prevNode.next;

            while(curr != null && curr != nxtNode)
            {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode revHead = prev;

            ListNode temp = prevNode.next;
            prevNode.next = revHead;
            prevNode = temp;
            prevNode.next = nxtNode;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode head, int k)
    {
        while(head != null && k>0)
        {
            head = head.next;
            k--;
        }

        return head;
    }

    private ListNode rev(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head.next;

        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
