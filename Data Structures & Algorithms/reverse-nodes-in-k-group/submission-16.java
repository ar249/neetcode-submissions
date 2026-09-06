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
            ListNode cur = prevNode.next;

            while(cur != nxtNode)
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

    private ListNode getKth(ListNode head, int k)
    {
        while(head != null && k != 0)
        {
            head = head.next;
            k--;
        }

        return head;
    }
}
