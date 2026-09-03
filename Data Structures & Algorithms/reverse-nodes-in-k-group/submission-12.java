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
            ListNode kth = getKth(prevNode, k);

            if(kth == null)
            {
                break;
            }

            ListNode nxtNode = kth.next;

            ListNode prev = nxtNode;
            ListNode curr = prevNode.next;

            while(curr != nxtNode)
            {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = prevNode.next;
            prevNode.next = kth;
            prevNode = temp;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode node, int k)
    {
        while(node != null && k != 0)
        {
            node = node.next;
            k--;
        }

        return node;
    }
}
