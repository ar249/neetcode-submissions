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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevNode = dummy;

        while(true)
        {
            ListNode kth = getkth(prevNode, k);

            if(kth == null) break;

            ListNode nxt = kth.next;
            ListNode cur = prevNode.next;
            ListNode prev = nxt;

            while(cur != nxt)
            {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur; 
                cur = temp;
            }

            ListNode temp = prevNode.next;
            prevNode.next = kth;
            prevNode = temp;
        }

        return dummy.next;
    }

    private ListNode getkth(ListNode node, int k)
    {
        while(node != null && k > 0)
        {
            node = node.next;
            k--;
        }

        return node;
    }
}
