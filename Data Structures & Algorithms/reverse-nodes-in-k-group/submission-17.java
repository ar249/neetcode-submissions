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
        ListNode prevNode = dummy;
        dummy.next = head;

        while(true)
        {
            ListNode kth = getKth(prevNode, k);

            if(kth == null) break;

            ListNode nxtNode = kth.next;

            ListNode prev = nxtNode;
            ListNode cur = prevNode.next;

            while(cur != nxtNode)
            {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur; 
                cur = temp;
            }

            ListNode tmp = prevNode.next;
            prevNode.next = kth;
            prevNode = tmp;
        }

        return dummy.next;
    }


    private ListNode getKth(ListNode node, int k)
    {
        while(node != null && k > 0)
        {
            node = node.next;
            k--;
        }

        return node;
    }
}
